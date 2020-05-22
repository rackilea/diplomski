Listener treeListener = new Listener () {
        @Override
        public void handleEvent (Event event) {
            switch (event.type) {                    
                   case SWT.MouseDoubleClick: {
                       Point coords = new Point(event.x, event.y);
                    TreeItem item = viewer.getTree().getItem(coords);

                    if (item != null) {                            
                        int columns = viewer.getTree().getColumnCount();
                        for (int i = 0; i < columns; i++) {
                            if (item.getBounds(i).contains(coords)) {
                                   System.out.println("Double Clicked on: " + item.getData() + " : " + i);
                               }
                        }
                     }
                 }
            }
        }
    };

    viewer.getTree().addListener (SWT.MouseDoubleClick, treeListener);