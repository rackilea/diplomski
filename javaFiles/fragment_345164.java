public static void main(String[] args) {
// get each file name in that particular directory here
    String s = "update_04082014_something-something.txt"; // matches
    String s1 = "update_05082014_something-something.txt"; // doesnt match
    String ddmmyy = "04082014";
    String pattern = ".*?_" + ddmmyy + ".*";
    System.out.println(s.matches(pattern));
    System.out.println(s1.matches(pattern));
}