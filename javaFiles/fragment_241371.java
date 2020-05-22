String line = "XXXX_YYYY_YYYYYYY_YYYYYYZZZZ";

        Pattern p = Pattern.compile("([^_]+(?:_[^_]*){2})$");
        Matcher m = p.matcher(line);
        if(m.find()) {
            System.out.println(m.group(1));
        }