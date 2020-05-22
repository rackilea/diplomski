public class Main  {

    public static void main(String[] args){
        ClassOut out = new ClassOut();
        ClassOut.ClassIn ob = out.new ClassIn() {

            @Override
            public double getValue() {
                return super.value;
            }
        };

        ob.print();
    }
}

class ClassOut{
    abstract class ClassIn{

        public void print() {

            System.out.println("Value: " + getValue());
        }

        double value = 20.5;
        public abstract double getValue();
    }
}