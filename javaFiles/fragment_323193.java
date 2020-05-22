public static void main(String[] args) {
    Party party = new Party();
    Guests guest = new Guests();

    party.setPartyDate("2012-09-03");
    guest.setGuestName("Albert");
    guest.setDrinkType("wine");
    party.setGuests(guest);

    JAXBContext context;
    try {
        context = JAXBContext.newInstance(Party.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(party, System.out);

    } catch (JAXBException e) {e.printStackTrace();}
}