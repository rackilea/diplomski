class EmptyTest {

    public static void main (String[] args) {

         Matcher m = Pattern.compile("").matcher("abc");
         while (m.find()) {
            System.out.println(m.start() + "," + m.end());
         }
    }
}