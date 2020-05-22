Root root = new Root();
root.fieldA = new ClassA();
root.fieldA.fieldB = "a";
root.fieldC = Arrays.asList("b", "c");
root.fieldD = "d";
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(root));