public Response handleRequest(IORunnable r){
     try {
         r.run();
     } catch(IOException e){
         // handle exception
     }
     //Common code follows
}