public void checkHosts(String subnet){
   int timeout=1000;
   for (int i=1;i<255;i++){
       String host=subnet + "." + i;
       if (InetAddress.getByName(host).isReachable(timeout)){
           System.out.println(host + " is reachable");
       }
   }
}