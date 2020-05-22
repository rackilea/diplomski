public static void main(String[] args) {
    try {
        new Scanner(new File("H:\\Hello.txt"));
        System.out.println("The file exists.");
    } catch (Exception e) {
        System.out.println("File not found: " + e.getMessage());
    }
}