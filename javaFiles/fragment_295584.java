class Thing {
    protected int a;
    protected int b;

    public void setB(int b) {
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Thing(){}

    public Thing(int a, int b) {
        this.a = a;
        this.b = b;
    }

    Thing copy() {                  // adding a copy method
        return new Thing(a, b);
    }

    public Thing transform() throws IllegalAccessException, InstantiationException {
        // Thing result = (Thing)this.getClass().newInstance(); // one way to do it (reflection)
        Thing result = copy(); // a better way to do it
        result.setA(a);
        result.setB(b+1);
        return result;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ThreeThing x = new ThreeThing(1);
        System.out.println(x.a + " : " + x.b);
        Thing y = x.transform();
        System.out.println(y.a + " : " + y.b);
    }
}

class ThreeThing extends Thing {

    public ThreeThing(){}

    ThreeThing(int b) {
        this.a = 3;
        this.b = b;
    }

    @Override
    Thing copy() {           // adding a copy method
        return new ThreeThing(b);
    }
}