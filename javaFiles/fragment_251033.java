for (int A = 0; A < text.length; A++) {
  for (int B = 0; B < text.length; B++) {
    if (A != B && text[A].equals(text[B])) {
         System.out.println("Repeated word:" + text[A]);
    }
  }
}