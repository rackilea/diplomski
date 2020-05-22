bool result = true;
do {
    String blah = sc.nextLine();
    Pattern userInput = Pattern.compile("^[a-zA-Z]+$");
    Matcher inputCheck = userInput.matcher("blah");
    result = //boolean check from your matcher object
    if(result) {
        //Complain about wrong input
    }
} while(result);