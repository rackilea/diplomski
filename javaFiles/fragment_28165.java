print(root.getChildren());
private void print(ObservableList<Node> children) {
        for(Node child: children){
            double width = child.getBoundsInLocal().getWidth();
            Object height = child.getBoundsInLocal().getHeight();
            double x = child.getTranslateX();
            double y = child.getTranslateY();
            System.out.println("trans x - y: " + x + " - "+y  + " width - height: " + width +" - "+ height);
        }
    }