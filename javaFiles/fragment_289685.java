public static void main(String[] args) {
    String test = ",,,";
    System.out.println(Arrays.toString(test.split(",", -1))); // adds leading and trailing empty Strings .
    // so effectively its like adding "" before , after and between each ","

    String test1 = "aa,bb,cc";
    System.out.println(Arrays.toString(test1.split(",",-1)));
}