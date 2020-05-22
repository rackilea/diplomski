class X{
    final int i;
    X(Y y){
        i = 5;
        y.x = this; // ouch, don't do this!
    }
}

class Y{
    public static Y y;
    public X x;
    Y(){
        new X(this);
    }
}

//... Some code in one thread
{
    Y.y = new Y();
}

//... Some code in another thread
{
    assert(Y.y.x.i == 5); // May fail!
}