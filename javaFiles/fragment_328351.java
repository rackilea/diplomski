public static void main(String[] args) {
    String raw = "<string xmlns=\"http://icacec.com/\">TRUE,Hrithik Sharma,201301-11</string>";
    raw = raw.substring(0, raw.lastIndexOf("<"));
    raw = raw.substring(raw.lastIndexOf(">") + 1, raw.length());
    String [] contents = raw.split(",");
    for (String txt : contents)
        System.out.println(txt);
}