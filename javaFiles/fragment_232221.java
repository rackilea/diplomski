String text = "(25, 4) (1, -6)";
    ArrayList<String> list = new ArrayList<String>();
    try {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    } catch (PatternSyntaxException ex) {
    }