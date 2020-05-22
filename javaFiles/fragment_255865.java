public class StackOverflow {
    public static void main(String[] args) {
        String data = "aaligatoor";

        int firstAindex = data.indexOf("a");
        int lastOindex = data.lastIndexOf("o");

        if (firstAindex > -1 && lastOindex > -1) {
            char[] letters = data.toCharArray();
            letters[firstAindex] = 'o';
            letters[lastOindex] = 'a';

            data = new String(letters);
        }
        System.out.println(data);
    }
}