public static int updateCounter() {

    String counterFileName = "counter.txt";

    int counter = 0;

    File counterFile = new File(counterFileName); 
    if (counterFile.isFile()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(counterFileName))) {         
            counter = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    try (FileWriter writer = new FileWriter(counterFileName)) {     
        writer.write(String.valueOf(++counter));
    } catch (IOException e) {
        e.printStackTrace();
        return 0;
    }

    return counter;
}