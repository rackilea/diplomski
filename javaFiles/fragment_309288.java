public void pause () { 
         try {
            Player.savePlayer(player);
         } catch (IOException e) {
            e.printStackTrace();
         }
 }