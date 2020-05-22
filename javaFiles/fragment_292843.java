String str = "ford-focus-albany-ny-v12356-l12205";
    String[] substrings = str.split("-");
    for (String arg: substrings) {
        if (arg.matches("v[0-9]*")) {
            String v = arg.substring(1);
        }
        else if (arg.matches("l[0-9]*")) {
            String l = arg.substring(1);
        }
    }