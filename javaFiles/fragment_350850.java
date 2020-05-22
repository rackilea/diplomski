// Create a new graph DB at path DB_PATH
GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );

// Create a new execution engine for running queries.
ExecutionEngine engine = new ExecutionEngine( db );

ExecutionResult result;

// Queries need to be run inside of transactions...
try ( Transaction ignored = db.beginTx() )
{
    String query = "MATCH (f:food)-[:categorized_as]->(c:category) RETURN f.food_name as foodName, c.category_name as categoryName";

    // Run that query we just defined.
    result = engine.execute(query);

    // Pull out the "foodNames" column from the result indicated by the query.
    Iterator<String> foodNames = result.columnAs( "foodName" );
    // Iterate through foodNames...
}