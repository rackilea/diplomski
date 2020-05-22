String regex = "^(\\S)*-(([^-])*)(-)+((\\S)+)\\s-\\s((\\S)+)\\s(.)*";
    Pattern pattern = Pattern.compile(regex);
    while ((strLine = br.readLine()) != null){
        Matcher matcher = pattern.matcher(strLine);
        boolean matchFound = matcher.find();
        if (matchFound){
            String s1 = matcher.group(2);
            String s2 = matcher.group(5);
            String s3 = matcher.group(7);
            System.out.println (s1 + " " + s2 + " " + s3);
        }

    }