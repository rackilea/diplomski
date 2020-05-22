public static void main(String[] args) throws Exception {
    String xmlString = "<MainTag><element><tag1>Key1</tag1><tag2>Not intrested</tag2><tag3>Value1</tag3></element><element><tag1>Key2</tag1><tag2>Not intrested</tag2></element><element><tag1>Key3</tag1><tag2>Not intrested</tag2><tag3>Value3</tag3></element></MainTag>";

    Matcher matcher = Pattern.compile("<(tag[13])>(.+?)</tag[13]>").matcher(xmlString);
    while (matcher.find()) {
        System.out.println(matcher.group(1) + " " + matcher.group(2));
    }
}