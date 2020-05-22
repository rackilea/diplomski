public class SkillsDemo3 {
    private static boolean again = true;
    private static int action;


    public static void main(String[] args) throws IOException {

        //***************************
        //Login
        //***************************

        class User {
            User (String username, String password)
            {
                this.username = username;
                this.password = password;
            }

            String GetUsername() {return username;}
            String GetPassword() {return password;}

            private String username;
            private String password;
        }


        String greeting = "Hello";
        String username;
        String password;

        // Used to hold the instance of a user who successfully logged in
        User loggedInUser = null;

        // Create an empty list to hold users
        List<User> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new User("Gerry","spintown"));
        listOfUsers.add(new User("Evelyn","poker"));
        listOfUsers.add(new User("Joan","bonus"));


        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));


        System.out.println("*** Welcome to the program ***\n");
        System.out.println(greeting);

        System.out.println("Please type your username :");
        username = br.readLine();
        System.out.println("Please type your password :");
        password = br.readLine();

        for (User user : listOfUsers)
        {
            if (user.GetUsername().equals(username))
            {
                if (user.GetPassword().equals(password))
                {
                    loggedInUser = user;
                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            System.out.println("User successfully logged in: "+loggedInUser.GetUsername());
        }
        else
        {
            System.out.println("Invalid username/password combination");
        }

        //**********************************
        //Choice of Games
        //**********************************
        again = true;
        action = 0;

        while (again)
        {
            System.out.println("Please type 1 for Rock, Paper, Scissors or 2 for Play pick up sticks:");
            action = Integer.parseInt(br.readLine());
            if (action == 1)
            {
                System.out.println("\nYou have chosen to play Rock, Paper, Scissors");
            }
            else if (action == 2)
            {
                System.out.println("\nYou have chosen to Play pick up sticks");
                again = false;
            }
            System.out.println("Please type 0 to continue or 1 to stop :");
            action = Integer.parseInt(br.readLine());
            again = action == 0;
            System.out.println("You typed : "+action);
        }
    }
}