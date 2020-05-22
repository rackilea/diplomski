public static void main(String[] args){
    String s = "3, V, 11, H, 21, H";
    String[] t = s.split(" [ ,]*|,[ ,]*");
    int first = Integer.parseInt(t[0]);
    int second = Integer.parseInt(t[2]);
    int third = Integer.parseInt(t[4]);
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
}