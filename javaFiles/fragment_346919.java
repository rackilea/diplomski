void bindScrollBars(TableView<?> firstTable, TableView<?> secondTable, Orienatation orieantation){
    ScrollBar firstScrollBar = null;
    ScrollBar secondScrollBar = null;

    for (Node node : firstTable.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar && ((ScrollBar) node).getOrientation().equals(orientation)) {
                firstScrollBar= (ScrollBar) node;
            }
    }

    for (Node node : secondTable.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar && ((ScrollBar) node).getOrientation().equals(orientation)) {
               secondScrollBar = (ScrollBar) node;
            }
     }

    if(firstScrollBar != null && secondScrollBar != null) { firstScrollBar.valueProperty().bindBidirectional(secondScrollBar.valueProperty()); }