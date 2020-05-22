List<Item> loadItems() throws FileNotFoundException {

    File phaseOneFile = new File("Phase-1.txt");
    Scanner readPhaseOneFile = new Scanner(phaseOneFile);
    List<Item> items = new ArrayList<Item>();

    while (readPhaseOneFile.hasNextLine()){
        String actualLine = readPhaseOneFile.nextLine();
        String[] actualLineToItem = actualLine.split("=");

        Item newItem = new Item();
        newItem.itemName=actualLineToItem[0];
        newItem.itemWeight= Integer.parseInt(actualLineToItem[1]);

        items.add(newItem);

    } 

    return items;

}