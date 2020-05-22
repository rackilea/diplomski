String s = "hello \"Luis Anderson\" your age is 30 and u will get $30";
        Pattern p = Pattern.compile("(?<=\\s|^)(\".*?\"|\\S*)(?=$|\\s)");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group(1));
        }