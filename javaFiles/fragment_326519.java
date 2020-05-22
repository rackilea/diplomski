class PortCheck{
    public static void main(String []args) throws Exception{
        String port = "80";
        if(args.length > 0)port = args[0];
        final int p = Integer.parseInt(port);
        Thread t = new Thread(){
            public void run(){

                try{
                    java.net.ServerSocket s = new java.net.ServerSocket(p);
                    System.out.println("\nListening on port " + p);
                    s.accept();
                }catch(Exception e){
                    System.out.println("Err " + e);
                }
            }
        };
        t.start();
        Thread.sleep(2000);
        System.out.println("Bye ");
        System.exit(0);
    }
}