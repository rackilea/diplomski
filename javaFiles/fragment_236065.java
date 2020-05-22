else if (isInteger(choice)) {
    betNum = Integer.parseInt(choice);
    if (betNum >= 0 && betNum <=39) {
       System.out.println("You have selected " +betNum);
       x = 1; //by the way, you can set x to be a boolean variable
    } else { //betNum not a valid Roulete number
       System.out.println("Invalid value: Must be odd, even, red, black or a number between 0 and 39");
       x=0;
    }
}