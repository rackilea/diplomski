public static void main(String[] args) {
    String a= "abc|aa||";
    String split = Pattern.quote("|");
    System.out.println(split);
    System.out.println(Arrays.toString(a.split(split)));
}