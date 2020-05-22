class First {
    First(Object o) {
        o.toString();
    }
}

class Second extends First {
    private final static Second instance = new Second(new Object());

    private Second(Object o) {
        super(o);
    }

    public static Second getInstance() {
        return instance;
    }    
}