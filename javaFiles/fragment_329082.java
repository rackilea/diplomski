public static void main( final String[] args )
{
    EmbeddedNeo4j hello = new EmbeddedNeo4j();
    hello.createDb();
    hello.removeData();
    hello.shutDown();
}