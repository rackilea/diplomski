//if (!userIn.hasNextLine() || !userIn.hasNextLine()) {
  if (!userIn.hasNextLine() || !passIn.hasNextLine()) {
            System.out.println("New users must set up their account: ");
            if (!userIn.hasNextLine()) {
                System.out.print("Enter a username: ");
                String username = in.nextLine().trim();
                userOut.print(username);
                userOut.flush();

            }
            //why again !userIn.hasNextLine(), you should check passIn
            //if (!userIn.hasNextLine()) {
              if (!passIn.hasNextLine()) {
                System.out.print("Enter a password: ");
                String password = in.nextLine().trim();
                passOut.print(password);
                passOut.flush();

            }
            System.out.println("Your account has been created. You may now log in:");
        }