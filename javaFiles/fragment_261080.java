if (number / 10 % 10 == 1) { // check second digit from the right first
    suffix = "th";
} else { // if it's not 1, do the switch.
    switch(abc%10){
         case 1: suffix = "st";break;
         case 2: suffix = "nd";break;
         case 3: suffix = "rd";break;
         default: suffix = "th";
    }
}
System.out.println(abc+suffix);