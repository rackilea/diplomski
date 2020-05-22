public class MyButton extends Group {

private ButtonBase label;
private ButtonBase arrowButton;
protected ContextMenu popup;
private ObjectProperty<SplitMode> splitMode;
private DoubleProperty sizeBinding;
private DoubleProperty layoutBinding;
private double oldSizeValue;
private double oldLayoutValue;
private PseudoClass layoutClass;

//
private static PseudoClass TOP_PSEUDO_CLASS = PseudoClass.getPseudoClass("top");
private static PseudoClass BOTTOM_PSEUDO_CLASS = PseudoClass.getPseudoClass("bottom");
private static PseudoClass LEFT_PSEUDO_CLASS = PseudoClass.getPseudoClass("left");
private static PseudoClass RIGHT_PSEUDO_CLASS = PseudoClass.getPseudoClass("right");
private static PseudoClass HIDDEN_PSEUDO_CLASS = PseudoClass.getPseudoClass("hidden");

public static enum SplitMode {
    SPLIT_TOP, // put arrow buton on top
    SPLIT_RIGHT, // put arrow button on right
    SPLIT_BOTTOM, // bottom
    SPLIT_LEFT, // left
    HIDDEN  // hides the arrow button regardless of visibility
}

private void changeToPseudoClass(PseudoClass newClass) {
    pseudoClassStateChanged(layoutClass, false);
    pseudoClassStateChanged(newClass, true);
    layoutClass = newClass;
}

private void bindHidden() {

    if (sizeBinding != null) {
        sizeBinding.unbind();
        sizeBinding.set(oldSizeValue);
    }
    if (layoutBinding != null) {
        layoutBinding.unbind();
        layoutBinding.set(oldLayoutValue);
    }
    arrowButton.setVisible(false);
    changeToPseudoClass(HIDDEN_PSEUDO_CLASS);
}

private void bindSizeAndLayout(DoubleProperty sizeFrom, ReadOnlyDoubleProperty sizeTo,
        DoubleProperty layoutFrom, ReadOnlyDoubleProperty layoutTo,
        PseudoClass newPseudoClass) {

    if (sizeBinding != null) {
        sizeBinding.unbind();
        sizeBinding.set(oldSizeValue);
    }
    if (layoutBinding != null) {
        layoutBinding.unbind();
        layoutBinding.set(oldLayoutValue);
    }
    oldSizeValue = sizeFrom.get();
    sizeBinding = sizeFrom;
    oldLayoutValue = layoutFrom.get();
    layoutBinding = layoutFrom;
    sizeFrom.bind(sizeTo);
    layoutFrom.bind(layoutTo);
    changeToPseudoClass(newPseudoClass);
    arrowButton.setVisible(true);
}

public void setSplitMode(SplitMode mode) {
    if (splitMode == null) {
        splitMode = new SimpleObjectProperty();
    }
    if (splitMode.get() == mode) {
        return;
    } // no changes needed   
    splitMode.set(mode);

    // set up new bindings
    switch (mode) {
        case SPLIT_BOTTOM:
            // bind arrowbutton width to label width
            // bind arrowbutton starting position to bottom of label
            bindSizeAndLayout(arrowButton.prefWidthProperty(), label.widthProperty(),
                    arrowButton.layoutYProperty(), label.heightProperty(),
                    BOTTOM_PSEUDO_CLASS);
            break;
        case SPLIT_RIGHT:
            // bind arrowbutton height to label height
            bindSizeAndLayout(arrowButton.prefHeightProperty(), label.heightProperty(),
                    arrowButton.layoutXProperty(), label.widthProperty(),
                    RIGHT_PSEUDO_CLASS);
            break;
        case SPLIT_LEFT:
            // bind arrowbutton height to label height
            bindSizeAndLayout(arrowButton.prefHeightProperty(), label.heightProperty(),
                    label.layoutXProperty(), arrowButton.widthProperty(),
                    LEFT_PSEUDO_CLASS);
            break;
        case SPLIT_TOP:
            // bind arrowbutton width to label height
            bindSizeAndLayout(arrowButton.prefWidthProperty(), label.widthProperty(),
                    label.layoutYProperty(), arrowButton.heightProperty(),
                    TOP_PSEUDO_CLASS);
            break;
        case HIDDEN:
            // unbind all and hide button
            bindHidden();
            break;
    }

}

public SplitMode getSplitMode() {
    return (splitMode == null) ? SplitMode.HIDDEN : splitMode.get();
}

public ObjectProperty splitModeProperty() {
    return splitMode;
}

public ButtonBase getButton() {
    return label;
}

public ButtonBase getArrowButton() {
    return arrowButton;
}

// Test suite
public MyButton() {
    this("");
}

public MyButton(String text) {
    this(text, SplitMode.SPLIT_RIGHT);
}

@SuppressWarnings("OverridableMethodCallInConstructor")
public MyButton(String text, SplitMode mode) {
    label = new Button(text);
    label.getStyleClass().setAll("label");
    arrowButton = new Button();
    // bind the managed property to visibility.
    // we dont want to manage an invisible button.
    arrowButton.managedProperty().bind(arrowButton.visibleProperty());
    arrowButton.getStyleClass().setAll("arrow-button");
    getStyleClass().setAll("split-menu-button");
    getChildren().clear();
    getChildren().addAll(label, arrowButton);
    setSplitMode(mode);

}

}// end of class