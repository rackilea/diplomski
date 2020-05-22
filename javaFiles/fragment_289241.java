String filename = "test.txt";
int numOfIds = 0;
try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    String line = null;
    while ((line = br.readLine()) != null) {
        if (line.contains("Product ID = ")) {
            numOfIds++;
        }
    }
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}