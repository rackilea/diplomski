String s = "a/b/c/d";
String[] array = s.split("/");
for (int i = 1; i <= array.length; i++) {
    String part = Arrays.stream(array).limit(i).collect(Collectors.joining("/"));
    System.out.println(part);
}