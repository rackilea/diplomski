public void getRMIServer(){
    Registry registry = null;
    Hello stub;
    try {
        System.out.println("IN RMI CLients");
        registry = LocateRegistry.getRegistry("localhost");
        stub = (Hello) registry.lookup("yash");
        System.out.println(stub.greeting());
    } catch (Exception e) {
        e.printStackTrace();
    }
}