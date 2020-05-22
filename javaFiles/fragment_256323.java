public static void main(String[] args) {
    try{
        URL url = Task.class.getResource("/resources/words.txt");
        Scanner scanner = new Scanner(url.openStream());
        System.out.println("" + scanner.next());
    } catch(IOException ex) {
        ex.printStackTrace();
    }
}