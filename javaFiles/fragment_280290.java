Node r = db.getNodeById(0);
String[] sequence = {"aaa","bbb","ccc"};

Traverser traverser = Traversal.description()
                .depthFirst()
                .expand(new ArrayExpander(sequence))
                .evaluator(Evaluators.atDepth(sequence.length()))
                .uniqueness(Uniqueness.NONE)
                .traverse(r);

for ( org.neo4j.graphdb.Path p : traverser )
        {
            //do something with the nodes accessible by p.nodes()
        }