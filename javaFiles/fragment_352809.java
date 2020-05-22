System.out.println("AM or PM?"); 
Scanner TimeOfDayQ = new Scanner(System.in);
TimeOfDayStringQ = TimeOfDayQ.next();

if(!TimeOfDayStringQ.equals("AM") && !TimeOfDayStringQ.equals("PM")) { // <--
    System.out.println("Sorry, incorrect input.");
    System.exit(1);
}

...

if(Hours == 13){
    if (TimeOfDayStringQ.equals("AM")) {
        TimeOfDayStringQ = "PM"; // <--
    } else {
        TimeOfDayStringQ = "AM"; // <--
    }
            Hours = 1;
    }
 }