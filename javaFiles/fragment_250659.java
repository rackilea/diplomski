private RectangleFigure fetchNode(String node_label) {
        RectangleFigure emptyNode = new RectangleFigure();
        // get the list of nodes drawn on canvas
        @SuppressWarnings("rawtypes")
        List childrens = panel.getChildren();  //private IFigure panel;

        for (int count = 0; count < childrens.size(); count++) {
            if (childrens.get(count) instanceof RectangleFigure) {
                RectangleFigure node = (RectangleFigure) childrens.get(count);
                @SuppressWarnings("rawtypes")
                List node_children = node.getChildren();
                for (int count2 = 0; count2 < node_children.size(); count2++) {
                    if (node_children.get(count2) instanceof Label) {
                        Label lbl = (Label) node_children.get(count2);
                        if (lbl.getText().equals(node_label)) {
                            return node;
                        }
                    }
                }
            }
        }

        return emptyNode;
    }