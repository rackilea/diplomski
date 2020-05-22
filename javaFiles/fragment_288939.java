public class Base {

    public int a = 1;
    protected int b = 2;
    private int c = 3;

    public Base(){

    }
}

public class Extended extends Base{

    public int a = 4;
    protected int b = 5;
    private int c = 6;

    public Extended(){

    }

    public void print(){
        //Fields from the superclass
        System.out.println(super.a);
        System.out.println(super.b);
        System.out.println(super.c); // not possible

        //Fields from the subclass
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
    }
}

public static void main(String[] args) {
        Extended ext = new Extended();
        ext.print();
    }