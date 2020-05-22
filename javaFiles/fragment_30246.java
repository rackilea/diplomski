public class TelaPrincipalController {

    @FXML
    private SwingNode swingComponentWrapper ;

    public void initialize() {
        SwingUtilities.invokeLater(this::createMxGraph);
    }

    private void createMxGraph() {
        mxGraph grafo = new mxGraph();
        Object parent = grafo.getDefaultParent();

        Object v1 = grafo.insertVertex(parent, null, "Brazil", 100, 100, 50, 40);
        Object v2 = grafo.insertVertex(parent, null, "Soccer", 240, 150, 50, 40);
        Object a1 = grafo.insertEdge(parent, null, "loves", v1, v2);

        mxGraphComponent graphComponent = new mxGraphComponent(grafo);

        swingComponentWrapper.setContent(graphComponent);
    }

    @FXML
    private void selecionarNo() {
        // ...
    }

    // etc etc...
}