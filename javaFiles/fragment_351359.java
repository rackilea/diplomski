public static void main(String[] args) {
    String out="SELECT * FROM EMP WHERE EMPID=10";
    String array[] = out.split("(?=\\s)",-1);

    for (String string : array) {       
    System.out.print(string);
    }
  }