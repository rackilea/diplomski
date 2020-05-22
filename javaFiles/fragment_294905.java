class Base
{
    int x = 1;

    void show() {        
        System.out.println(x);
    }
}

class Child extends Base
{
    public static void main(String s[]) {

        Child c = new Child();

        c.show();
        c.x = 2;
        c.show();
    }     
}