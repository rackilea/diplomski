try {
   ...
} catch (FileNotFoundException e) {
  System.out.println("File not found: " + e.getMessage());
} catch (.. other subclasses ..) {
   ...
} catch (IOException e) { // anything else
  System.out.println("I/O Exception: " + e.getMessage());
  e.printStackTrace();
}