class A
{
    private List<Personat> personList;

    public List<Personat> getPersonList() { return personList; }

    public void handle(HttpExchange t) throws IOException
    {
        // ...
        personList = ...;
        // ...
    }
}