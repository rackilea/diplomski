webView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouse) {
                    if (mouse.getButton() == MouseButton.SECONDARY) {
                        menu = new ContextMenu();
                       //add some menu items here
                       menu.show(this, mouse.getScreenX(), mouse.getScreenY());
                    } else {
                        if (menu != null) {
                            menu.hide();
                        }
                    }
                }
            });