ArrayList<MyNode> nodes = new ArrayList<MyNodes>();
// add SQL code to load values from DB
// make sure to load the nodes sorted by their lft values.
for ( int c = 0; c < nodes.size(); c++ )
{
    String result = createNodeListFor(nodes.elementAt(c), nodes);
    if ( result != null )
    {
        System.out.println(result);
    }
}