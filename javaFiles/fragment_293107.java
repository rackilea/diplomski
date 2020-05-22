public class SerializationAndDeserializationOfTicket {

    public static void main(String[] args) {
        List<Ticket> listOfTickets = new ArrayList<>();
        listOfTickets.add(new Ticket("Concert 1", LocalDateTime.now()));
        listOfTickets.add(new Ticket("Concert 2", LocalDateTime.now()));
        listOfTickets.add(new Ticket("Concert 3", LocalDateTime.now()));

        writeTicketToFile(listOfTickets);

        readTicketFromFile();
    }

    public static void writeTicketToFile(List<Ticket> tickets) {

        try {
            FileOutputStream fileOut = new FileOutputStream("tickets.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (int i = 0; i < tickets.size(); i++) {
                objectOut.writeObject(tickets.get(i));
            }
            objectOut.close();
        } catch (IOException e) {
            System.err.println("JVM reported an IO exception. Please, take a look.");
        }
    }

    public static void readTicketFromFile() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(new File("tickets.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (true) {
                try {

                    Ticket ticket = (Ticket) oi.readObject();
                    tickets.add(ticket);
                    System.out.println(ticket.getName() + " " + ticket.getIssued());
                } catch (EOFException ex) {
                    oi.close();
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("JVM reported an IO/ClassNotFound exception. Please, take a look.");
    }
    }