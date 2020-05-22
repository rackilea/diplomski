protected void moveBall() {
    if (x <= radius || x >= getWidth() - radius) {
        dx *= -1; // Change direction
    }
    // Adjust ball position
    x += dx; 

    //#######################################
    setTranslateX(x); // Move the Pane!!! ###
    //#######################################
}