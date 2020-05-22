while (c.hasNextLine()) {
     line = c.nextLine();
     if (!line.startsWith("#")) {
         fruitList.add(line);
     }
}