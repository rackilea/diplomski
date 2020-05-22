public class Main {

    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(NiceClass.class);
        System.out.println("Setter: " + info.getPropertyDescriptors()[0].getWriteMethod());
        // prints "Setter: public void Main$NiceClass.setPE_DATAB(java.lang.String)"
        System.out.println("Name of variable: " + info.getPropertyDescriptors()[0].getName());
        // prints "Name of variable: PE_DATAB"
    }

    public class NiceClass {

        private String PE_DATAB;

        public void setPE_DATAB(String PE_DATAB) {
            this.PE_DATAB = PE_DATAB;
        }

    }

}