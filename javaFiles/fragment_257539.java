String cadena = "2,2345";
    Pattern pattern2 = Pattern.compile("([0-9]+),([0-9]+)");
    Matcher matcher = pattern2.matcher(cadena);
    if (matcher.find()){
        System.out.println("Found " + matcher.group(1) + " - " + matcher.group(2));
    }

    // Prints: Found 2 - 2345