public void dragOver(DropTargetDragEvent dtde)
        {
            Point dropPoint = dtde.getLocation();
            TreePath path = tree.getPathForLocation(dropPoint.x, dropPoint.y);
            Rectangle pathBounds = tree.getPathBounds(path);
            Rectangle topHalf = new Rectangle(pathBounds.x, pathBounds.y, pathBounds.width, pathBounds.height / 2);
            if (topHalf.contains(dropPoint))
            {
                System.out.println("top half");
            }
            else
            {
                System.out.println("bottom half");
            }
         }