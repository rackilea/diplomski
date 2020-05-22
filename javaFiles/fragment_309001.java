final String REG_NAME = "<b>Name:</b>(.*)<br />";

        String text = "<b>Name:</b> Photomatix.Pro.v4.0.64bit-FOSI<br />";

        Pattern pattern = Pattern.compile(REG_NAME);

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }