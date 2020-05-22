public class MyParameter {

    private boolean b;
    private Integer i;

    public MyParameter(Integer i, boolean b) {
        this.b = b;
        this.i = i;
    }

    // getters

}

new Executable<Void, MyParameter>() {

    public Void execute(MyParameter params) {
        // something special
        System.out.println(params.getI());
        return null;
    }

}