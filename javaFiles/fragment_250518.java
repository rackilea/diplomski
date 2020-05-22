public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ticket t = new Ticket();
        System.out.println("Enter the no of bookings:");
        int b = sc.nextInt();
        System.out.println("Enter the available tickets:");
        t.setAvailableTickets(sc.nextInt());
        while (b > 0) {
            System.out.println("Enter the ticketid:");
            t.setTicketid(sc.nextInt());
            System.out.println("Enter the price:");
            t.setPrice(sc.nextInt());
            System.out.println("Enter the no of tickets:");
            int n = sc.nextInt();
            System.out.println("Available Tickets: " + t.getAvailableTickets());
            int cost = t.calculateTicketCost(n);
            System.out.println("Total amount:" + cost);
            System.out.println("Available ticket after booking:" + t.getAvailableTickets());
        }
    }
}