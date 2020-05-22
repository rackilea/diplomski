TraversalDescription td = Traversal.description()
              .depthFirst()
              .relationships(RelTypes.REL, Direction.INCOMING)
              .evaluator(new Evaluator() {
                @Override
                public Evaluation evaluate(final Path path) {
                    Node endNode = path.endNode();
                    if ( endNode.getProperty("name").equals('d') ){
                       return Evaluation.INCLUDE_AND_PRUNE;
                                        }
                    else {
                       return Evaluation.INCLUDE_AND_CONTINUE;
                    }

                }
            });

for ( Path path : td.traverse(aNode) ) {
   Iterator<Relationship> iter = endNode.getRelationships(RelTypes.LOVE,Direction.INCOMING).iterator();
  if ( iter.hasNext() ) {
     Path extendedPath = ExtendedPath.extend(path, iter.next());
     for ( Node enode :  extendedPath.nodes() )
         System.out.print(enode.getProperty("name") + "---");       
   }
}