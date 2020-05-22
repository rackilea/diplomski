public void subscribe(final String channel) {
   while(true){
       try {
          // blocking command
          client.subscribe(channel);
          return;
       } catch(ConnectionException e) {
          // ignored
       }
   }
}