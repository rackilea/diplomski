int value;
while(true) {
    // a number please.
    try {
         value = Integer.parseInt(in.nextLine());
         if (value > 0)
              break;
         // not positive. 
    } catch (NumberFormatException e) {
         // not an integer
    }
}