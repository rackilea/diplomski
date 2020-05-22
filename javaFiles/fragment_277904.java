input = bufferedReader.readLine();
String[] args = input.split(" +"); // split on one or more spaces
if (args[0].equals("search")) {
    if (args.length > 2) {
        // args may be an array like {"search", "-c", "5"}.
        // After you confirm that, you may need to convert args[2]
        // from a String to an int using Integer.parseInt
        // (more code here)
    }
}