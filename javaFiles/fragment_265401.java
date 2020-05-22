String s = null;
try {
  s.charAt(10);
} catch ( NullPointerExeption e ) {
  System.out.println("null");
  e.printStackTrace();
} catch ( StringIndexOutOfBoundsException e ) {
  System.out.println("String index error!");
  e.printStackTrace();
} catch ( RuntimeException e ) {
  System.out.println("runtime exception!");
  e.printStackTrace();
}