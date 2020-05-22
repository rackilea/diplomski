import java.util.Arrays;
    import java.util.Scanner;

    public class ArrayCopy {
        String[] entries = new String[0];

        public void add(Scanner stdIn)
        {
            entries = Arrays.copyOf(entries, entries.length + 1);

            Contact add = new Contact(); // Instantiate new Contact instance

            String name;
            System.out.print("Enter the contact's name: ");
            name = stdIn.next();
            add.setName(name); // set name in Contact class

            String address;
            System.out.print("Enter the contact's address: ");
            address = stdIn.next();
            add.setAddress(address); // set address in Contact class

            String phone;
            System.out.print("Enter the contact's phone number: ");
            phone = stdIn.next();
            add.setPhone(phone); // set phone number in Contact class

            String email;
            System.out.print("Enter the contact's email address: ");
            email = stdIn.next();
            add.setEmail(email); // set email address in Contact class

            entries[entries.length-1] = add.toString();

            System.out.println(Arrays.toString(entries));

        } // end add

        public static void main(String[] args) {
            ArrayCopy program = new ArrayCopy();
            Scanner scan = new Scanner(System.in);
            String op = "";

            System.out.println("Press A to add a user or E to exit.");
            while(!(op = scan.nextLine()).equalsIgnoreCase("E")){
                switch(op){
                    case "A":
                        program.add(scan);
                        break;
                    case "E":
                        System.out.println("Good Bye.");
                        System.exit(0);
                }
            }

        }
    }