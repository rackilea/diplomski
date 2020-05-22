new GremlinPipeline(g.getVertex(1)).out().loop(1, 
    new PipeFunction<LoopPipe.LoopBundle<Vertex>,Boolean>() {
        public Boolean compute(LoopPipe.LoopBundle<Vertex> argument) {
            return true;
        }
    }, 
    new PipeFunction<LoopPipe.LoopBundle<Vertex>,Boolean>() {
        public Boolean compute(LoopPipe.LoopBundle<Vertex> argument) {
            return argument.getObject().getProperty("someProperty").equals("emitIfThis");
        }
    })