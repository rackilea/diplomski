GremlinPipeline pipe = new GremlinPipeline();

pipe.start(graph.getVertex("#18:0"));
pipe.out();

List<Vertex> currentTokenList = pipe.toList();
for (Vertex currentToken : currentTokenList) { //with the currentToken we can start a new GremlinPipeline
    System.out.println("aktuelles Token " + currentToken);
    GremlinPipeline pipe2 = new GremlinPipeline();
    pipe2.start(currentToken);
    pipe2.out();
    List<Vertex> currentRIDList = pipe2.toList();
    for (Vertex ridVertex : currentRIDList) {
        System.out.println(ridVertex);
    }
}