Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "neo4j" ) );
Session session = driver.session();

StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title" );

while ( result.hasNext() ) {
    Record record = result.next();
    gson.toJson(record.asMap());
}
session.close();
driver.close();