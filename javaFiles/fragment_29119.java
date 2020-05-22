public class Filewrite {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name:: ");
        String name = in.nextLine();
        System.out.print("Enter your marks in subject 1:: ");
        int marks1 = in.nextInt();
        System.out.print("Enter your marks in subject 2:: ");
        int marks2 = in.nextInt();
        System.out.print("Enter your marks in subject 2:: ");
        int marks3 = in.nextInt();

        System.out.println("Name    " + name);
        System.out.println("Marks1  " + marks1);
        System.out.println("Marks2  " + marks2);
        System.out.println("Marks3  " + marks3);
        File f = new File("testdata.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("name=" + name);
            bw.newLine();
            bw.write("Marks1=" + marks2);
            bw.newLine();
            bw.write("Marks2=" + marks2);
            bw.newLine();
            bw.write("Marks3=" + marks2);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}