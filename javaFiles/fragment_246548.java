public static void main(String[] args){
    try {
        System.out.println("RMI Server Started");
        HelloImpl hello = new HelloImpl();
        UnicastRemoteObject.unexportObject(hello, true);
        Hello stub = (Hello) UnicastRemoteObject.exportObject(hello, 0);
        Registry reg = LocateRegistry.createRegistry(1098);
        reg.rebind("yash", stub);
        System.out.println("server.RMI Server is ready.");
    } catch (Exception e) {
        e.printStackTrace();
    }

}