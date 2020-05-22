String[] str  = new String[]{"0:ADD(10)","1:ADD(20)"};
        Pattern pattern = Pattern.compile("^.*\\((\\d+)\\).*$");
        for (int i = 0; i < str.length; i++)
        {
            Matcher m = pattern.matcher(str[i]);
            System.out.println(m.matches());
            System.out.println(m.group(1));
        }