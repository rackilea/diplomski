class InnerBase<T> {
    protected int eger;
    ... most code
}

class Sinner extends Outer.Inner {
}

Outer outer = new Outer();
Inner sinner = outer.new Sinner();