for (int i = 0; i < tokens.length; i++) {
   String[] coordinates = tokens[i].replace("{", "").replace("}", "").split(",");

   int x = Integer.parseInt(coordinates[0].split("=")[1]);
   int y = Integer.parseInt(coordinates[1].split("=")[1]);

   moviments[i] = new Point(x, y);
}