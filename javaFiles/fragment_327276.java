String inputString = "java java java. JAVA!";

        int counter = 0;
        Pattern pattern = Pattern.compile("JAVA");
        Matcher match = pattern.matcher(inputString.toUpperCase());
        while (match.find()) {
            counter++;
        }

        System.out.println(counter);