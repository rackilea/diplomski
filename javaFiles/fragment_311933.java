Comparator<Ticket> mc;
mc = new TicketIdComparator();
Collections.sort(tickets, mc);


final class TicketIdComparator implements Comparator<Ticket>

{

    @Override
    public int compare(Ticket ticket1, Ticket ticket2) {
        String TicketId1 = ((Ticket) ticket1).getNumber();
        String TickedId2 = ((Ticket) ticket2).getNumber();

        int num1=Integer.parseInt(TicketId1);
        int num2 =Integer.parseInt(TickedId2);

        if (num1<num2)
            return 1;
        else if (num1>num2)
            return -1;
        else
            return ticket1.getName().compare(ticket2.getName());
    }
}