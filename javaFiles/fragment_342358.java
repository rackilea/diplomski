public class ImmutabilityOfReferenceInstance {

        public static void main(String[] args) {

             MClass mc = new MClass();
             mc.setId(1);

             ImClass imc = new ImClass(mc);
             System.out.println("imc = " + imc); // should print 1

             mc.setId(2);

             System.out.println("imc = " + imc); // should still print 1 if immutability works

             imc.getmClass().setId(3);

             System.out.println("imc = " + imc); // should still print 1 if immutability works
        }
    }

    final class ImClass {

        final private MClass mClass;

        public ImClass(MClass mClass) {
            this.mClass = (MClass)mClass.clone();
        }

        public MClass getmClass() {
            return (MClass)mClass.clone();
        }   

        @Override
        public String toString() {      
            return String.valueOf(mClass.getId());
        }

    }

    class MClass implements Cloneable{
        private int id;


        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }   

        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }