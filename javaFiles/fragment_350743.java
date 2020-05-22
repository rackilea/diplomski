public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    c.set(2010, 10, 20, 22, 37, 12);

    Date start = c.getTime();

    Date end = new Date();


    long diff = (end.getTime() - start.getTime()) / 1000;

    long days    = diff / (60 * 60 * 24);
    long hours   = diff / (60 * 60) - days * 24;
    long minutes = diff / 60 - (hours * 60 + days * 24 * 60);
    long seconds = diff % 60;

    String output = "";
    if (days >= 1) 
        output += days + " day" + ((days > 1) ? "s" : "");

    if (hours >= 1) 
        output += " " + hours + " hour" + ((hours > 1) ? "s" : "");

    if (minutes >= 1) 
        output += " " + minutes + " minute" + ((minutes > 1) ? "s" : "");

    if (seconds >= 1) 
        output += " " + seconds + " second" + ((seconds > 1) ? "s" : "");

    output = output.trim();

    System.out.println(output);
}