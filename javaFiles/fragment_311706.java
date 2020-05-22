static class Super {
    public Date getValue() {
        return new Date();
    } // 1
}

static class Sub extends Super {
    public Timestamp getValue() {
        return new Timestamp(System.currentTimeMillis());
    } // 2

}

public static void main(String[] args) {
    Super b = new Sub();
    System.out.println(b.getValue());
}