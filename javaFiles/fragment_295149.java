System.out.println("Please enter your words");
    Scanner userInput = new Scanner(System.in);

    Vector<String> v = new Vector<String>();
    String longest = "";
    longest = userInput.nextLine(); //get the first array of words for checking
    v.add(longest);

    while (true) {

        for(String s : v) //iterate to all the array of words
        {
            if(longest.length() < s.length()) //check if the last longest word is greater than the current workd
                longest = s; //if the current word is longer then make it the longest word
        }
        System.out.println("Longest Word: " + longest + " lenght: " + longest.length());

        v.add(userInput.nextLine());
    }