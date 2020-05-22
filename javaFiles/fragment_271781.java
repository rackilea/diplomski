try (FileReader reader = new FileReader("/Users/mulangsu/Desktop/temp.txt")) {
    System.out.println(reader.read());
} catch (FileNotFoundException e) {
    System.out.println("File not found");
} catch (IOException e) {
    e.printStackTrace();
}