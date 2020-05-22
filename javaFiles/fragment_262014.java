List<Path> longestPaths = null;
int longestLength = 0;

for ( Path position : Traversal.description()
        .depthFirst()
        .relationships( Rels.INCLUDE )
        .relationships( Rels.LIKES, Direction.OUTGOING )
        .evaluator( new Evaluator {
            public Evaluation evaluate(Path path) {
                Relationship r = path.lastRelationship();
                if(r != null && "on".equals(r.getProperty("status"))) {
                    return Evaluation.INCLUDE_AND_CONTINUE;
                }

                return EXCLUDE_AND_PRUNE;
            }
        } )
        .traverse( node ) )
{
    //Given that node is your start node this would be the (WHERE ALL rels status = on)

    if(longestPaths == null || longestLength < position.length()) {
        longestPaths = new ArrayList<Path>();
        longestPaths.add(position);
        longestLength = position.length();
    }
}

//At this point you should have a collection of the longest paths