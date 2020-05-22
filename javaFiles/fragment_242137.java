class Best implements Cloneable
{
    int x;
    int y;
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();   
    }
}

class Test implements Cloneable
{
    int a;
    int b;
    Best bt = new Best();

    public Object clone()throws CloneNotSupportedException
    {
        Test t = (Test) super.clone();
        t.bt = (Best) this.bt.clone();
        return t;   
    }
}