class Overload {
    B4 subOb = new B4(1, 2, 3);

    public static void main(String[] args) {
        Overload obj = new Overload();
        obj.doStuff();
    }

    public void doStuff() {
        subOb.show("This is k: "); // this calls show() in B4, also cannot resolve symbol 'show`
        subOb.show();              // this calls show() in A4, also cannot resolve symbol `show`
    }
}