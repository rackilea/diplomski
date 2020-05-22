private Node createNode() {  
        final BorderPane bp = new BorderPane();  
        bp.setOnDragDetected(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent event) {  
                Dragboard db = bp.startDragAndDrop(TransferMode.MOVE);  
                ClipboardContent clipboard = new ClipboardContent();  
                final int nodeIndex = bp.getParent().getChildrenUnmodifiable()  
                        .indexOf(bp);  
                clipboard.putString(Integer.toString(nodeIndex));  
                db.setContent(clipboard);  
                event.consume();  
            }  
        });  
        bp.setOnDragOver(new EventHandler<DragEvent>() {  
            @Override  
            public void handle(DragEvent event) {  
                boolean accept = true;  
                final Dragboard dragboard = event.getDragboard();  
                if (dragboard.hasString()) {  
                  try {
                    int incomingIndex = Integer.parseInt(dragboard.getString());  
                    int myIndex = bp.getParent().getChildrenUnmodifiable()  
                            .indexOf(bp);  
                    if (incomingIndex == myIndex) {  
                        accept = false;  
                    }  
                  } catch(java.lang.NumberFormatException e) {
                    //handle null or not number string in clipboard
                    accept = false;
                  }
                } else {  
                    accept = false;  
                }  
                if (accept) {  
                    event.acceptTransferModes(TransferMode.MOVE);  
                }  
            }  
        });  
        bp.setOnDragDropped(new EventHandler<DragEvent>() {  
            @Override  
            public void handle(DragEvent event) {  
                boolean success = false;  
                final Dragboard dragboard = event.getDragboard();  
                if (dragboard.hasString()) {  
                  try {
                    int incomingIndex = Integer.parseInt(dragboard.getString());  
                    final Pane parent = (Pane) bp.getParent();  
                    final ObservableList<Node> children = parent.getChildren();  
                    int myIndex = children.indexOf(bp);  
                    final int laterIndex = Math.max(incomingIndex, myIndex);  
                    Node removedLater = children.remove(laterIndex);  
                    final int earlierIndex = Math.min(incomingIndex, myIndex);  
                    Node removedEarlier = children.remove(earlierIndex);  
                    children.add(earlierIndex, removedLater);  
                    children.add(laterIndex, removedEarlier);  
                    success = true;  
                  } catch(java.lang.NumberFormatException e) {
                    //handle null or not number string in clipboard
                  }
                }  
                event.setDropCompleted(success);  
            }  
        });  
        bp.setMinSize(50, 50);  
        return bp;  
    }