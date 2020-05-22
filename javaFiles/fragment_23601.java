public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");
        isDragMode = true;
        dragPoint.x = e.getX();
        dragPoint.y = e.getY();

        switch (shapeString) {
            case "Line":
                shape.setDragPoint(dragPoint.x, dragPoint.y);  //here i set the drag points to the already created line at step 1
                break;
            case "FreeHand":
                shape = new FreeShape();
                break;
        }

        getGraphics().drawImage(drawingImage, 0,0,null); //Added this line
        shape.drawWhileDragging(getGraphics()); // i call this method to draw while mouse is dragging
    }