channel.connect();

     // My added code begins here
     while (channel.getExitStatus() == -1){
        try{Thread.sleep(1000);}catch(Exception e){System.out.println(e);}
     }

     channel.disconnect();
     session.disconnect();
     // My Added code ends here

   }
   catch(Exception e){
     System.out.println(e);
   }
}