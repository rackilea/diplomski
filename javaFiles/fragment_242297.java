public static void main(String args[]){
    Double d = 5.14;
    String afterD = String.valueOf(d);
    afterD =afterD.substring(afterD.indexOf(".") + 1);
    System.out.println(afterD);
}