public static void main(String[] args) throws Exception{
    List<Predator> predatorList = new ArrayList();
    String fileLocation = System.getProperty("user.dir");
    String dataPath = fileLocation + File.separator + "predators.txt";

    java.io.File file = new java.io.File(dataPath);
    Scanner input = new Scanner(file);

    input.useDelimiter(":");

    List<Predator> predatorList = new ArrayList();
    Predator predator = new Predator();             

    for (int i = 0; input.hasNext(); i++) {
        predator.setPredatorName(input.next());
        predator.setLatinName(input.next()));
        ...
        predatorList.add(predator);
    }
}