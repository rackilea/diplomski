String m = "n-us; micromax d320 build/kot49h) ";
    String pattern = "micromax\\s(.*?)\\s";
    Pattern r = Pattern.compile(pattern);
    Matcher m1 = r.matcher(m);
    if (m1.find()) {
        System.out.println(m1.group(1));

    }