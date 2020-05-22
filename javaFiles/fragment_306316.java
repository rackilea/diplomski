Player[] myPlayer = null;     // first word uncapitalized, every 
    Player[] myNewPlayer = null;  // other word begins with a capital

    //open Players.txt
    int i, n; // combine the variables into 1 line        
    String filename = "players.txt";

    try {

        FileReader fp = new FileReader(filename);
        BufferedReader bf = new BufferedReader(fp);
        n = Integer.parseInt(bf.readLine());
        // not needed
        //myPlayer = new Player[n];
        // NOT NEEDED int x = n + 1;
        myNewPlayer = new Player[n + 1];

        for (i = 0; i < n; i++) {
            String s = bf.readLine();
            String user, score; // combine variables, doesnt need to initalize them

            String[] items = s.split(","); // Splits the line into array elements on every delimiter -> ,

            //user = s.substring(0, s.indexOf(","));
            //s = s.substring(s.indexOf(",") + 1);
            //score = s;
            user = items[0];
            score = items[1];
            // this line below isnt actually needed
            //myPlayer[i] = new Player(user, Double.parseDouble(score));
            // Create a new player clone, dont copy the previous one
            myNewPlayer[i] = new Player(user, Double.parseDouble(score));

        }

        // We've read all the variables from the text file, now we create the last one
        // Since myNewPlayer is (n+1) size, the range of the array is
        // 0 to n
        // the last index will be n                            New Score Variable
        myNewPlayer[n] = new Player("Username variable", Double.parseDouble("22"));

        bf.close();
        fp.close();
    } catch (IOException e) {
        System.out.println("Exception was " + e.getMessage());
    }

    //----------------------------------WRITE mytxt!-------------
    // This is called a ternary operator
    // it is a 1 line if statement
    // the format is like so
    //   booleanLogic ? trueAnswer Execution : falseAnswer Execution;
    //         if ()  {       true          }else {         false  }
    n = myNewPlayer != null ? myNewPlayer.length : 0;
    // CHANGED HERE - was using the first array rather than second
    // dont need the 1st array
    try {
        filename = "players.txt";
        FileWriter fp = new FileWriter(filename);
        // Dont need "" before the items
        fp.write(n + "\n");
        for (i = 0; i < n; i++) {
            fp.write(myNewPlayer[i] + "\n");
        }

        fp.close();
    } catch (IOException e) {
        System.out.println("Exception was " + e.getMessage());
    }
    //----------------------------------WRITE mytxt!-----------

    //Get on Message
    String s = "";
    for (i = 0; i < myNewPlayer.length; i++) {
        // s += ""; is like doing s = s + "";
        s += myNewPlayer[i] + "\n";
    }

    JOptionPane.showMessageDialog(null, "Players are \n " + s);