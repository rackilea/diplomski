ProMJGraphPanel visualizeGraph(PluginContext context,
                               CPNGraph graph, // instanceof AbstractResetInhibitorNet
                               ViewSpecificAttributeMap map) {
    ProMGraphModel model = new ProMGraphModel(graph);
    GraphLayoutConnection layoutConnection = new GraphLayoutConnection(graph);
    layoutConnection.expandAll();
    ProMJGraph jgraph = new ProMJGraph(model, map, layoutConnection);
    ...
}