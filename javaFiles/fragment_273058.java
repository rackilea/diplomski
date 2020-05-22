public void sendMessage(MyBookAccount to, String message) {
    friend = to; 
    if (to.loggedIn != true) {
        System.out.println("Could not post message from " + name
                + ". " + to.name + " is not logged in!");
        latestMessage = "(none)";
    } else if (to.loggedIn == true) {
        latestMessage = message;
    }
}