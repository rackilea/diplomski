interface CanPR{
    void pr();
}

class Foo implements CanPR{
    @Override
    public void pr() {
        System.out.println("pr from Foo");
    }
}

class Bar implements CanPR{
    @Override
    public void pr() {
        System.out.println("pr from Bar");
    }
}


class X {

    public <T extends CanPR> void go(T x) {
        x.pr();
    }

    public static void main(String[] args) {
        CanPR a = new Foo();
        CanPR b = new Bar();

        X x = new X();

        x.go(a); //prints: pr from Foo
        x.go(b); //prints: pr from Bar
    }
}