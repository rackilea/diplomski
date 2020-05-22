found=true;
        static String testcase1 = "-4-12-2*12-3-4*5";
        Pattern SEGMENT_PATTERN = Pattern.compile("(\\d+(\\.\\d+)?|\\D+)");
        /*\\d-means digit,
        \\.-point,
        +-one or more times,
        ?-optional and 
        \\D-non digit ch*/
        Matcher matcher = SEGMENT_PATTERN.matcher(testcase1);
        while (found) {
                    boolean Found = matcher.find();
                    String segment = matcher.group();//representing a number or an operator

                        if (Character.isDigit(segment.toCharArray()[0])) {
                            //is digit
                        }
                        else {
                            //is operator

                        }
                    }