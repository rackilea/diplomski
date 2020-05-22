for (int i = 0; i < pane.getChildren().size(); i++) {
     Node child1 = group.getChildren().get(i);
     if (child1 instanceof VBox) {
         for(Node child2:((VBox) child1).getChildren()) {
             if (child2 instanceof TextField) {
                 contentToSave += (TextField) child2.getText();
             }
          }
      }
   }