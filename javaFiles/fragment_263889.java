class A {
    private int a;
    public void foo(){
        System.out.println(a);
    }
}

class AA extends A {
    private int a; //its not the same 'a'!!
    public void foo(){ //ok, we override, so we can 'overwrite', but...
        super.foo(); //... what with this?
        System.out.println(a);
    }
}