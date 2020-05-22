public class Test {
    public static void main(String[] args) {
        String line = "Trump Tower 23445";
        int pos = line.replaceFirst("^(\\D+).*$", "$1").length();
        String number = line.substring(pos);
        System.out.println(Integer.parseInt(number));
        System.out.println(line.substring(0, pos));
    }
}