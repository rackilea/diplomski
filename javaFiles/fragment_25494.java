Set<Node> dividers = primarySplitPane.lookupAll(".split-pane-divider");

for (Node divider : dividers) {
    if (divider.getParent() == primarySplitPane)
        divider.setOnMouseClicked(e -> System.out.println("Primary Clicked" ));
    else if (divider.getParent() == secondarySplitPane)
        divider.setOnMouseClicked(e -> System.out.println("Secondary Clicked"));

}