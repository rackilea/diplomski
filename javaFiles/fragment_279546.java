public class Citizen {
    ...
    @JsonDeserializer(contentUsing=MyListDeserializer.class) 
    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }
}