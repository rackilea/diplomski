// observable properties to represent start and end nodes for drag:
ObjectProperty<NamedDragAwareImageView> source = new SimpleObjectProperty<>();
ObjectProperty<NamedDragAwareImageView> destination = new SimpleObjectProperty<>();


Pane root = new Pane();
// create your named image views, referencing the source and destination
// and add their image views to root, e.g.
NamedDragAwareImageView red = new NamedDragAwareImageView(source, destination, "Red", "red.png");
root.getChildren().add(red.getView());

// recommend using SVG paths (i.e. javafx.scene.shape.Path) for the arrow
// easy to draw programmatically, easy to manipulate elements etc:
Path arrowHead = new Path();
MoveTo arrowHeadStart = new MoveTo();
arrowHead.getElements().add(arrowHeadStart);
arrowHead.getElements().addAll(/* draw an arrow head with relative path elements... */);
arrowHead.setVisible(false);
// avoid arrowHead interfering with dragging:
arrowHead.setMouseTransparent(true);

// this will contain a MoveTo and a bunch of LineTo to follow the mouse:
Path arrowLine = new Path();
arrowLine.setMouseTransparent(true);

root.getChildren().addAll(arrowHead, arrowLine);

// change listener for source. source is set when drag starts:
source.addListener((obs, oldSource, newSource) -> {
    if (newSource == null) return ;
    arrowHeadStart.setX(/* x coord based on newSource */);
    arrowHeadStart.setY(/* similarly */);
    arrowHead.setVisible(true);
});

// change listener for destination. destination is only set
// when drag complete:
destination.addListener((obs, oldDestination, newDestination) -> {
    if (newDestination != null) {
        System.out.println("User dragged from "+source.get().getName()+
            " to "+destination.get().getName());
    }
});

root.setOnMouseDragOver(e -> {
    if (source.get()==null && destination.get()!=null) {
        // update arrowStart position
        // add line element to arrowLine
    }
});

root.setOnMouseReleased(e -> {
    // clear arrow:
    arrowHead.setVisible(false);
    arrowLine.getElements().clear();
});