Color bgColor;
String givenColor="blUe";
Map<String, Color> colors = new HashMap<>();
colors.put("RED", Color.RED);
colors.put("BLUE", Color.BLUE);
colors.put("WHITE", Color.WHITE);
colors.put("GREEN", Color.GREEN);

bgColor=colors.get(givenColor.toUpperCase());