private boolean isLong(String message){
    if (message.matches("[0-9]+")) {
        try {
            long callbackNumberLong = Long.parseLong(message);
            System.out.println("That was a number!");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("That was NOT a number!");
            return false;
        } 
    } else {
        return false;
    }
}