public static void main(String[] args) throws IOException {
    Process process = Runtime.getRuntime().exec("tasklist.exe");
    Scanner scanner = new Scanner(new InputStreamReader(process.getInputStream()));
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
    scanner.close();
}