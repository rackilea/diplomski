public void mouseClicked(MouseEvent arg0) {
}

/**
 * handles mouse pressed event
 */
public void mousePressed(MouseEvent arg0)
{
    // if filling we shouldn't add anything 
    if(b_Filling == true)
        return;
    // if dragging we shouldn't add anything
    if(isDragging == true)
        return;

    // handles first vertex for each polygon
    if(i_ThreeVertices == 0)
    {
        p_Start = arg0.getPoint();
        p_End = new Point();
        p_FirstVertex = new Point(p_Start);
    }
    else
    {
        // not the first vertex
        p_Start = new Point(p_End);
        p_End = arg0.getPoint();
    }

    // adds the vertex
    b_Drawing = true;
    addAPoint();
    b_Drawing = false;
    b_repaintFlag = true;
    // repaints
    this.repaint();
}

/**
 * handles mouse released event
 */
public void mouseReleased(MouseEvent arg0)
{
    // if filling we shouldn't add a vertex.
    if(b_Filling == true)
        return;

    if(b_FirstVertexInPolygon == true && isDragging == false)
    {
        // unlocks first vertex state
        b_FirstVertexInPolygon = false;
        return;
    }

    // save previous vertex and add current if mouse is dragged 
    // and more than non vertices
    if(isDragging == true && i_ThreeVertices != 0)
    {
        p_Start = new Point(p_End);
        p_End = arg0.getPoint();

        isDragging = false;
        b_Drawing = true;
        // adds a vertex
        addAPoint();
        b_Drawing = false;
    }
    else
        p_End = arg0.getPoint();
    b_repaintFlag = true;
    // repaint
    this.repaint();
}

/**
 * handles mouse dragged event
 */
public void mouseDragged(MouseEvent arg0)
{
    // repaints if not filling
    if(b_Filling == true)
        return;
    p_End = arg0.getPoint();
    isDragging = true;
    b_repaintFlag = true;
    this.repaint();
}

/**
 * handles mouse moved event
 */
public void mouseMoved(MouseEvent arg0)
{
    // if not filling, and we have at least one vertex
    // and not dragging mouse, then repaint.
    if(b_Filling == true)
        return;
    if(i_ThreeVertices == 0)
        return;
    if(isDragging == true)
        return;
    p_End = arg0.getPoint();
    b_repaintFlag = true;
    this.repaint();
}

public void mouseEntered(MouseEvent arg0){
}

public void mouseExited(MouseEvent arg0){
}