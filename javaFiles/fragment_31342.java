public class SomeClass {

    // any other code in the class...

    public void addParticipant() {

        int startNumber = allParticipants.size() + 100;

        System.out.println("First name: ");
        String name = readString();
        System.out.println("Last name: ");
        String lastName = readString();
        System.out.println("Team: ");
        String team = readString();

        allParticipants.add(new Participant(name, lastName, startNumber));

        System.out.println(name + " " + lastName + " from " + team + " with number " + startNumber + " added \n");
    }
}