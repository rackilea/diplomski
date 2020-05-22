if(hasMoreCommands() == true){
    do {
        str = input.nextLine().trim();

        // Strip out any comments
        if (str.contains("//")) {
            str = (str.substring(0, str.indexOf("//"))).trim();
        }
    } while (str.startsWith("//") || str.isEmpty() || hasMoreCommands());
    command = str;
}