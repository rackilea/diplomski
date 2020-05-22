String input1 = "Input 1";
    String input2 = "Input 2";
    int x = (int) ((Math.random() * (2)) + 0); //Generate random number between 0 and 1
    String randomString = "";
    if (x == 0) {
        randomString = input1;
    } else if (x == 1) {
        randomString = input2;
    }
    System.out.println(randomString);