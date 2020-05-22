Scanner sc = new Scanner(
        "www.youtube.com/watch?v=9HJ2fl4zbx0&amp;feature=youtube_gdata");
String openStr = "www.youtube.com/watch?v=";
while (sc.hasNextLine() && (inputLine = sc.nextLine()) != null) {
    int pos = inputLine.indexOf(openStr);
    if (pos > -1) {
        pos += openStr.length();
        System.out.println(inputLine.substring(pos, pos + 11));
    }
}