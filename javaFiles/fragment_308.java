Pattern akPattern = Pattern.compile("ak\":\"([^\"]+)");
    Matcher matcher = akPattern.matcher(jsonAsString);

    matcher.find();
    String akValue = matcher.group(1);

    System.out.println(akValue);