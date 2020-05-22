class OuterClass {
    void foo() { System.out.println("Outer foo"); }

    View.OnClickListener mListener1 = new View.OnClickListener() {
        void foo() { System.out.println("Inner foo"); }

        @Override public void onClick(View view) {
            foo(); //Calls inner foo
            OuterClass.this.foo(); //Calls outer foo
        }
    }

    View.OnClickListener mListener2 = new View.OnClickListener() {
        @Override public void onClick(View view) {
            foo(); //Calls outer foo
            OuterClass.this.foo(); //Calls outer foo
        }
    }
}