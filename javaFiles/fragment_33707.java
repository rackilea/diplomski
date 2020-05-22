static synchronized void broadcast(Socket sender, String message, String name) throws IOException { //Add the sender socket here.
        // Sends the message to every client including the sender. 
        Socket s; 
        PrintWriter p; 
        for (int i = 0; i < clientList.size(); i++)
        { 
            s = clientList.get(i);
            if(s != sender) { //If the client is not equal to sender.
                p = new PrintWriter(s.getOutputStream(), true); 
                p.println(name+": "+message);
            } 
        } 
}