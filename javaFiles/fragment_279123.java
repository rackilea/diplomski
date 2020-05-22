public class Y {...}

public class Ytype1 extends Y {...}

public class X<T extends Y> {
    public List<T> ys;
    ...
}

public class Xtype1 extends X<Ytype1> {
    // super.ys is now List<Ytype1>
}