List<String> versions = Arrays.asList("0", "1", "000.0.0", "100.2.3","1.2.3", "..9", "00007", "090876", "9.00098000.00", "9.0900000.00", "-13.0.4", "1a.0.4b", "1.2");
    Pattern pattern = Pattern.compile("^0*([1-9][0-9]{0,2})?(?:\\.([0-9]{0,3}?)0*(?:\\.([0-9]{0,3}?)0*)?)?$");
    for (String v : versions) {
        Matcher matcher = pattern.matcher(v);
        Boolean matches = matcher.matches();
        Integer groups = matcher.groupCount();
        System.out.print(v + " evaluates to " + matches);
        // groups is always 3, because the empty string also matches
        if (matches) {
            String major = matcher.group(1);
            if (major == null || major.isEmpty()) {
                major = "0";
            }
            String minor = matcher.group(2);
            if (minor == null || minor.isEmpty()) {
                minor = "0";
            }
            String beta = matcher.group(3);
            if (beta == null || beta.isEmpty()) {
                beta = "0";
            }
            System.out.println(" ---> " + major + "." + minor + "." + beta);
        } else {
            System.out.println();
            // error handling
        }
    }