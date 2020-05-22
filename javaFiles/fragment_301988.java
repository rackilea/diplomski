public class MyCellPanel extends Panel {

    MyCellPanel(String componentId, final IModel<Classification>rowModel, final Tree tree) {
        super(componentId, rowModel);
        add(new TreeLinkPanel("treeLink", rowModel, tree); {
        add(new ClassificationNewLink("classificationNewLink", rowModel, tree); {

    }

}