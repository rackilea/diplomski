public static List<List<Element>> findPathsBetweenSimple(final Vertex from, final Vertex to) {
    final Object endID = to.getId();
    GremlinPipeline<Vertex, List<Element>> pipe = new GremlinPipeline<>(from);
    pipe.as("startAt")
            .out()
            .loop("startAt", new PipeFunction<LoopBundle<Vertex>, Boolean>() {
                @SuppressWarnings("unchecked")
                @Override
                public Boolean compute(LoopBundle<Vertex> lb) {
                    Boolean doContinue = Boolean.TRUE;
                    LOG.trace("Loop cnt: " + lb.getLoops() + "; Vertex: " + lb.getObject());
                    if (containsLoop(lb.getPath(), lb.getObject())) {
                        LOG.debug("Loop detected in path. Aborting. " + lb.getPath());
                        doContinue = Boolean.FALSE;
                    } else if (endID.equals(lb.getObject().getId())) {
                        LOG.debug("Path found: " + lb.getPath() + ", " + lb.getObject());
                        doContinue = Boolean.FALSE;
                    }
                    return doContinue;
                }
            })
            .has("id", endID)
            .path();
    return pipe.toList();
}