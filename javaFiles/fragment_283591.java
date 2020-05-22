String text = "a -> b; \n" +
      "c -> d; \n" +
      "e -> f;\n" +
      "g -> h;\n" +
      "i -> j; ";
Scanner sc = new Scanner(text).useDelimiter("\\s*->\\s*|;\\s*");
while(sc.hasNext()) {
  System.out.println(sc.next());
}