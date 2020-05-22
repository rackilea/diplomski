public <P extends Product> List<P> queryProducts (Class<P> clazz) {

    List<P> response = new ArrayList<P>();
    ...
    return response;
}