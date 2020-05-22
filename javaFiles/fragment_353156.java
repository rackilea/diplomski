@Test
  public void testSortedGroupCount() throws Exception {
    Graph graph = getAirRoutes();
    GraphTraversalSource g = graph.traversal();
    Map<Object, Long> counts = g.V().hasLabel("airport").groupCount()
        .by("region").order(Scope.local).by(Column.values,Order.decr).next();
    // https://stackoverflow.com/a/49361250/1497139
    assertEquals(1473, counts.size());
    assertEquals("LinkedHashMap",counts.getClass().getSimpleName());
    debug=true;
    if (debug)
      for (Object key : counts.keySet()) {
        System.out.println(String.format("%s=%3d", key, counts.get(key)));
      }

  }