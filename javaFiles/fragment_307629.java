try {
  int foo = Integer.parseInt("foo");
} catch (NumberFormatException e) {
  String message = e.getMessage();
  System.out.println(message.substring(19, message.length() - 1));
}