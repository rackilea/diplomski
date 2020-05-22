private void networking() {
    server_address = setServerName();
    if(server_address == null || server_address.equals("")){
        //Handle what happens when the server name is empty (or the user clicked the cancel button. If you let the execution continue, then the try/catch block below will pop up the second jInputDialog
    }
        try {

            PORT = setPortNumber();
            if (server_address != null) {

                sock = new Socket(InetAddress.getByName(server_address) ,
                    PORT);
            } 
            else {
                SocketException sc = new SocketException();
                throw sc;
            }
...
}