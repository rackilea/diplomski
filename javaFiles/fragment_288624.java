public static void main(String... args) {

 String s = "12:12:1990";
 System.out.println(s.matches("(\\d+|\\w+|([0-2][0-9]|([3]([0]|[1]))):([0][1-9]|[1][1-2]):([1][9][0-9][0-9]|[2][0][0-9][0-9]))"));

}