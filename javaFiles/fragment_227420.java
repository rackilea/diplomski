public void run() {
        String line;
        try {
            while (true) {
                line = input.readLine();
                if (line.equals("!end")) {
                     // Blah
                } else if(line.equals("!getusers")){
                    getOnlineUsers();
                    break;    << This breaks your read loop
                }
                broadcast(name, line); // method  of outer class - send messages to all
            } // end of while
        } // try
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } // end of run()