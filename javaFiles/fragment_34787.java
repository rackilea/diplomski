import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;

    public class Read {
        public static void main(String[] args) {
            File file = new File("numbers.txt");

            try {

                @SuppressWarnings("resource")
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {

                    System.out.println(sc.nextLine());

                }

            } catch (FileNotFoundException e) {

                System.out.println("File not found!");

            }
        }

    }