mainActivity.displayMessage("Connected to: "
            + client.getInetAddress().getHostName()); 
 mainActivity.displayMessage(message);

 public void displayMessage(String string) {
   listItems.add(string);
   adapter.notifyDataSetChanged(); 
   }