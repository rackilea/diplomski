abstract class Abs implements Visitable { }
abstract class AbsOther { }

class A extends Abs {

    public void accept(Visitor v) {
        v.visit(this);
    }

}

class B extends Abs {

    public void accept(Visitor v) {
        v.visit(this);
    }

}

class AOther extends AbsOther {

}

class BOther extends AbsOther {

}