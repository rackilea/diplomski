class OuterClass {
    protected void finalize() throws Throwable {
        System.out.println("oc instance finalized..");
    };
    String ocs = "ocs";

class InnerClass {
    String ics = "ics";

    protected void finalize() throws Throwable {
        System.out.println("IC instance finalized");
    };

    void innerMeth() {
        System.out.println(ocs);
    }
}