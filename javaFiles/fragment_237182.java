List<InventoryRow> videos = new ArrayList<InventoryRow>();
while (s.hasNextLine()) {
    String[] split = s.nextLine().split("   ");
    // TODO: make sure the split has correct format

    // x.charAt(0) returns the first char of the string "x"
    videos.add(new InventoryRow(split[0], split[1], split[2].charAt(0), split[3])); 
}