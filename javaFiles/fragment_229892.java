public static void main(String[] args) {
    if (args.length == 2 && args[0].equals("--args")) {
        args = args[1].split(";;");
    }

    // Continue as normal 
}