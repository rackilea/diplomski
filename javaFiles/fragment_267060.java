try ( Session session = driver.session() )
{
    List<String> list = new LinkedList<>();
    list.add("Jon");
    list.add("Doe");
    list.add("Bruno");

    session.writeTransaction( new TransactionWork<String>()
    {
        @Override
        public String execute( Transaction tx )
        {
            StatementResult result = tx.run(
                    "FOREACH(name IN $names | CREATE (p:Person) SET p.name = name)",
                    parameters( "names", list ) );
        }
    });
}