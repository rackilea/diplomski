class AA{
    int x;
    protected AA() {
        System.out.println(this.getClass().getName()); // "BB"
        System.out.println(this instanceof BB);        // true
        init(1008);
    }
    protected void init(int x)
    {
        this.x = x;
    }
}
class BB extends  AA{
    public BB() {
        init(super.x * 2);
    }
    public void init(int x)
    {
        super.x = x+1;
    }
}
public class Main  {

    public static void main(String[] args) {
        BB tst = new BB();
        System.out.println(tst.x);
    }
}