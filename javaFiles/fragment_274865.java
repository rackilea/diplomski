String[] colors = new String[] { "red", "green", "blue", "orange" };
 List<String> colorsList = Arrays.asList(colors);

 HashSet<String> colorsSet = new HashSet<>();
 colorsSet.addAll(colorsList);
 System.out.println(colorsSet);