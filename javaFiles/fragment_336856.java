class TicketWithUserProxy extends BaseEntityProxy{

    private UserProxy userProxy;
    private TicketProxy ticketProxy;

    public UserProxy getUserProxy() {
        return userProxy;
    }

    public void setUserProxy(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    public TicketProxy getTicketProxy() {
        return ticketProxy;
    }

    public void setTicketProxy(TicketProxy ticketProxy) {
        this.ticketProxy = ticketProxy;
    }
}