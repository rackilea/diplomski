StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title" );
while ( result.hasNext() )
{
    Record record = result.next();
    System.out.println( record.get( "title" ).asString() + " " +  record.get("name").asString() );
}