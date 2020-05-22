public class Main {
    public static void main(String[] args) {
        new Main().menu();
    }

    ArrayList<File> allFiles = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("Add - Adds a file");

        while (sc.next().equalsIgnoreCase("Add")) {
            getDocs();
        }
    }

    public void getDocs() {
        Scanner sc = new Scanner(System.in);
        allFiles.add(new File(sc.nextLine()));
        System.out.println(allFiles.toString());
    }
}