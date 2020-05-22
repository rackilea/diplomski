public static void main(String[] args) {

    //check if there were any command line arguments
    if (args.length > 0) {
        // args[0] is the first command line argument unlike C where args[0] would give u the executable's name
    } else {
        System.err.println("Usage: java -jar <jar_name> [directory_names..]");
    }
}