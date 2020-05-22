class X{
    final int i;
    X(){
        new Y(this); // ouch, don't do this!
        i = 5;
    }
}

class Y{
    Y(X x){
        assert(x.i == 5);//This assert should be true, since i is final field, but it fails here
    }
}