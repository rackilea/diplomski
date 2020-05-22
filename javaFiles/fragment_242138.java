class Best
{
    int x;
    int y;
}

class Test implements Cloneable
{
    int a;
    int b;
    Best bt = new Best();

    public Object clone()throws CloneNotSupportedException
    {
        Test t = (Test) super.clone();
        t.bt.x = this.bt.x;
        t.bt.y = this.bt.y;
        return t;   
    }
}