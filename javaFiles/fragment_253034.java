public static void main(String[] args) {
    if (args.length == 0) {
        System.out.println("You need to pass in at least one argument to run this program."); }
    if (args.length >= 1) {
        String longestArg = "";
        for (int i = 0; i < args.length(); i++) {
            if (args[i].length() > longestArg.length()) {
                longestArg = args[i];
            }
        }
        System.out.println("The longest argument is " + longestArg + " with length " + longestArg.length());