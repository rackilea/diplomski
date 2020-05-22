class A{
    private int a=0;
    A(){
        B b = new B();
        b.set(this);

    }

    public void change(int f){
        a= f;
    }
}

class B{
    void set(A x){
        x.change(5); // or any pass value
    }
}