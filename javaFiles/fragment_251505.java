class Campaign {
    @JacksonXmlElementWrapper(localName = "flights")
    private List<Flight> flights;

    // getters, setters, toString
}