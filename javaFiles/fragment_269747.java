class A {
    int i;
    A(int i) { this.i = i; }
    public String toString() { return ""+i; }
    A go(A a){
        a = null; // the reference to a2 was passed in, but is set to null
                  // a2 is not set to null - this copy of a reference is!
        return a; // null is returned
    }
    public static void main(String [] args){
        A a1 = new A(1); // 1 obj
        A a2 = new A(2); // 2 obj
        A a3 = new A(3); // 3 obj
        a3 = a1.go(a2); // a3 set to null and flagged for GC - see above for why
        a1 = null; // so far, a1 and a3 have been set to null and flagged

        test(a1);
        test(a2);
        test(a3);

    }
    static void test(A a) {
        try { System.out.println(a); } 
        catch(Exception e) { System.out.println((String)null); }
    }
}