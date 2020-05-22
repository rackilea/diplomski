class Foo {
    final myObject obj;
    final String str;
    final int num;

    Foo(myObject obj, String str, int num) {
        this.obj = obj;
        this.str = str;
        this.num = num;
    }

    static Foo Foo(myObject obj, String str, int num) {
        return new Foo(obj, str, num);
    }
}