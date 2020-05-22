List<String> names = new ArrayList<String>();
Scanner playerNamesScan = ...
while(playerNamesScan.hasNextLine() && index < theList.length) {
    String name = playerNamesScan.nextLine(); 
    names.add(name);
}