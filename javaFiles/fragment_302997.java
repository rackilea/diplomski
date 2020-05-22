new Thread() {
  public void run() {
     while(true) {

        try{
            ArrayList<Socket> arr = new ArrayList(clients.values());
                for(int i=0; i<Main.clients.size(); i++){
                    try
                     {
                        InetAddress addr = InetAddress.getByName(arr.get(i).getInetAddress().toString().replace("/", ""));

                        System.out.println(addr.isReachable(1000));


                     }
                     catch (IOException e)
                     {
                    System.out.println("connection probably lost");
                                    e.printStackTrace();
                      }
                 }
          Thread.sleep(1000);
         } catch (Exception e) { System.out.println("Shit happens: "+e); }
      }}
}.start();