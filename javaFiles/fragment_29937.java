try {
    blah...
 } catch (IOException e) {
     Throwable cause = e.getCause();
     System.out.println(cause.getMessage());
}