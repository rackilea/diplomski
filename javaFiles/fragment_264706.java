String regex = "(?<=^([^\"]*|[^\"]*\"[^\"]*\"[^\"]*))\\bint\\b(?=([^\"]*|[^\"]*\"[^\"]*\"[^\"]*)$)";
    System.out.println(regex);
    String[] tests = new String[] { 
            "int i;", 
            "String example = \"int i\";", 
            "logger.i(\"int\");", 
            "logger.i(\"int\") + int.toString();" };

    for (String test : tests) {
        System.out.println(test.matches("^.*" + regex + ".*$") + ": " + test);
    }