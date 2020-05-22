class MainClass {
    public static void main( String[] args ) {
        MainClass mc = new MainClass();
        InnerClass ic = mc.getObj();
        System.out.println( ic );
    }

    public InnerClass getObj() {
        return this.new InnerClass();
    }

    private class InnerClass {
        InnerClass() {}
    }
}