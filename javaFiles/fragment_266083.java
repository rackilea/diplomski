File f = new File(System.getProperty("user.home"), "file.txt");
try (Scanner scanner = new Scanner(f)) {
    scanner.useDelimiter("\\Z");
    String output = scanner.next();
    System.out.println(output);
} catch (Exception e) {
    e.printStackTrace();
}