public void m1() {
    int k = 30;
    class inner {
        public void m2() {
            System.out.println(k);
        }
    }
    inner o = new inner();
    k = 42;     // <= Note the reassignment here.
    o.m2();
}