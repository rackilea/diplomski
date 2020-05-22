int tries = 4;
        while (tries>=0) {
            out.println(login);

            //login
            String username = in.readLine();
            System.out.println("Client's username: " + username);

            String password = in.readLine();
            System.out.println("Client's password: " + password);

            if (username.equals("hello123") && password.equals("mypass")) {
                out.println("Correct login!");
                System.out.println ("Client's IP Address: " + localaddr.getHostAddress());
            }

            else if (!username.equals("hello123")||!password.equals("mypass")) { //if wrong login - give 3 more tries

                tries--;
                System.out.println("Number of tries left: " + tries);
                out.println("Try again, enter username and password. Login attempts left - " + tries);
            }
        }
        if (tries==0){
            out.println("Wrong login - server closing");
            out.close();
            skt.close();
            srvr.close();
        }