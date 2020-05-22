new GremlinPipeline(graph).V().has("mgrNo",T.neq,0).sideEffect(new PipeFunction<Vertex, Object>(){
    @Override
    public Object compute(Vertex vertex) {
        @SuppressWarnings("rawtypes")
        Vertex mgr = (Vertex) new GremlinPipeline(graph).V().has("empNo", vertex.getProperty("mgrNo")).next();
        return mgr.addEdge("manages", vertex);
    }
}).iterate();