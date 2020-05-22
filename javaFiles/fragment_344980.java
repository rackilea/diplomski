import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MatrixCompare {

    public static void main(String[] args) {

        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("1", "John", "456456", "35"));
        contacts.add(new Contact("2", "Jack", "123123", "20"));
        contacts.add(new Contact("3", "Mary", "234234", "24"));
        contacts.add(new Contact("4", "Jane", "345345", "18"));

        System.out.println("Initial List\n");
        printContacts(contacts);

        System.out.println("\n\nSorted by Id\n");
        Collections.sort(contacts, new SortById());
        printContacts(contacts);

        System.out.println("\n\nSorted by Name\n");
        Collections.sort(contacts, new SortByName());
        printContacts(contacts);

        System.out.println("\n\nSorted by Person Id\n");
        Collections.sort(contacts, new SortByPersonId());
        printContacts(contacts);

        System.out.println("\n\nSorted by Age\n");
        Collections.sort(contacts, new SortByAge());
        printContacts(contacts);

    }

    private static void printContacts(List<Contact> contacts) {
        for (int i=0; i<contacts.size(); i++) {
            System.out.println(contacts.get(i).id + " - " + contacts.get(i).name + " - " + 
                    contacts.get(i).getPersonId() + " - " + contacts.get(i).getAge());
        }
    }

    private static class Contact {

        String id;
        String name;
        String personId;
        String age;

        public Contact(String id, String name, String personId, String age) {
            this.id = id;
            this.name = name;
            this.personId = personId;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPersonId() {
            return personId;
        }

        public String getAge() {
            return age;
        }

    }

    private static class SortById implements Comparator<Contact> {
        @Override
        public int compare(Contact o1, Contact o2) {
            String name1 = o1.getId();
            String name2 = o2.getId();  
            return name1.compareTo(name2);
        }
    }
    private static class SortByName implements Comparator<Contact> {
        @Override
        public int compare(Contact o1, Contact o2) {
            String name1 = o1.getName();
            String name2 = o2.getName();    
            return name1.compareTo(name2);
        }
    }
    private static class SortByPersonId implements Comparator<Contact> {
        @Override
        public int compare(Contact o1, Contact o2) {
            String name1 = o1.getPersonId();
            String name2 = o2.getPersonId();    
            return name1.compareTo(name2);
        }
    }
    private static class SortByAge implements Comparator<Contact> {
        @Override
        public int compare(Contact o1, Contact o2) {
            String name1 = o1.getAge();
            String name2 = o2.getAge(); 
            return name1.compareTo(name2);
        }
    }

}