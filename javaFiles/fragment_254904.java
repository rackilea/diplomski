public static void main(String[] args) {
    String s = "abcdefghijk";
    int i1 = s.indexOf("cd")+2; // add index + length of substring (i.e, 2)
    int i2 = s.indexOf("ij");
    System.out.println(s.substring(i1,i2));

}

O/P :
efgh