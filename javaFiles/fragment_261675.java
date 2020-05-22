for (Screen screen : Screen.getScreens()) {
            Rectangle2D bounds = screen.getVisualBounds();

            Button btn = new Button("Move me to Screen " + index++);
            btn.setOnAction((e) -> {
                stage.setX(bounds.getMinX() + 100);
                stage.setY(bounds.getMinY() + 100);
            });
            root.getChildren().add(btn);
        }