class Base{
    public String str = "hello";
}

class Derived extends Base{
    private String str = "whatever";

    public Derived(){
        super.str = "abc";
        str = "def";
    }

    void foo(){
        System.out.println(str.equals(super.str));
    }
}

public static void main(String[] args){
    new Derived().foo();
}