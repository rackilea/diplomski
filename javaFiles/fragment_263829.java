class MyClass {
    public static final int DEFAULT1 = 1;
    public static final int DEFAULT2 = 2;
    public static final int DEFAULT3 = 3;

    // assume attr1 is optional
    private int attr1;
    // assume attr2,3 is mandatory
    private int attr2;
    private int attr3;


    public MyClass(MyClassBuilder myClassBuilder) {
        this.attr1 = myClassBuilder.attr1;
        this.attr2 = myClassBuilder.attr2;
        this.attr3 = myClassBuilder.attr3;
    }

    //Builder Class
    public static class MyClassBuilder {

        // required parameters
        private int attr2;
        private int attr3;
        // optional parameters
        private int attr1;

        public MyClassBuilder(int attr2, int attr3){
            this.attr2 = attr2;
            this.attr3 = attr3;
        }

        public MyClassBuilder setAttr1(int attr1) {
            this.attr1 = attr1;
            return this;
        }


        public MyClass build(){
            return new MyClass(this);
        }

    }

}