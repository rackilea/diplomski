public static void main(String[] args) {
  String str = "1";
  int a = Integer.valueOf(str);                 // java.lang.Integer return(ed)
  int b = Integer.parseInt(str);                // primitive (int) return(ed)
  System.out.printf("a = %d, b = %d\n", a, b);
}