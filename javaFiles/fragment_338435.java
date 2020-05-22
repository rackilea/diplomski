final DragSourceListener dsl = new DragSourceListener() {
            public void dragEnter(DragSourceDragEvent e) {
                e.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
                Rectangle bounds = SwingUtilities.getRoot(DnDTabbedPane.this).getBounds();

                if(bounds.contains(e.getLocation())){
                    tearTab.detach(); 
                }
            }

            public void dragExit(DragSourceEvent e) {
                e.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
                tearTab.attach(e.getLocation());
            }
            ...