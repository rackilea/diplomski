public static <T extends Vehicle> void readInFile(String fileName, ArrayList<T> targetList, Class<T> clazz) throws IOException {
    Scanner inFile = new Scanner(new FileInputStream(fileName));
    while (inFile.hasNextLine()){
        String[] params = inFile.nextLine().split("\t");
        try {
            Constructor<T> constructor = clazz.getConstructor(String[].class);
            T t = constructor.newInstance((Object[]) params);
            targetList.add(t);
        } catch (NoSuchMethodException | SecurityException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException("Problem with constructor", e);
        }
    }
}