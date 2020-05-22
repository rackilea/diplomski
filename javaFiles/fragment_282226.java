public static void main(String []args){
    Link b = new Link() {
        @Override
        public void mySampleMethod() {
            System.out.println("hello");
        }
    };
    b.mySampleMethod();
}