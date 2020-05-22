String str = "Lorem ipsum dolor [cookie:firstname] adipiscing elit.";
    Pattern pattern = Pattern.compile(".*?\\[.*?:(.*?)\\].*");
    Matcher matcher = pattern.matcher(str);

    if (matcher.find()){
        System.out.println(matcher.group(1));
    }