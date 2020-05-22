class System {
    private String property1;
    private String property2;
    private String property3;
    private String instanceName;

    public System (String instance){
        instanceName = instance;
    }

    public void showProperties() {
        java.lang.System.out
            .println("Displaying properties for instance of "+instanceName+"object System:"
                    + "\nProperty#1: " + property1 + "\nProperty#2: "
                    + property2 + "\nProperty#3: " + property3);
    }
}