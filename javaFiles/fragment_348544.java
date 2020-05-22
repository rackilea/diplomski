if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    if (j == 1) {
                        paths.add(path);
                        root.getChildren().add(new DragablePath(path));
                        cachePath.add(path);
                         cacheType.add("Create");


                    }
                }