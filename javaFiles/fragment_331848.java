Vertex nl = countries.iterator().next().asVertex();

GremlinPipeline<Vertex, Vertex> pipe = new GremlinPipeline<>();

pipe.start(nl).inE("LOCATED_IN").outV();

Iterable<City> cities = framedGraph.frameVertices(pipe, City.class);

for (City city : cities) {
    System.out.println(city.getName());
}