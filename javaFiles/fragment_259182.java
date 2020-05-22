public class Main {
    public static void main(String[] args) {
        LinkedList <Student>  l1 = new LinkedList<Student>();
        Scanner sc = new Scanner(System.in);

        int i=0;
        int choice;
        String name;
        String cne;

        do {
            Student e1 = new Student();
            System.out.println("Student name "+i);

            name = sc.nextLine();
            e1.setName(name);

            System.out.println("Student CNE "+i);
            cne = sc.nextLine();
            e1.setCne(cne);

            System.out.println(e1);

            l1.add(e1);

            System.out.println("type 1 to continue, other to quit : ");
            choice = sc.nextInt();
            sc.nextLine();
            i++;
        }while( choice == 1 );


        for ( i=0 ; i < l1.size() ; i++) {
            System.out.println(l1.get(i));
        }
    }
}