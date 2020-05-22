private boolean hasPiece = false;
//...

public void mouseClicked(MouseEvent e){
    if (hasPiece) {
        // Move the piece that the user previously selected...
        hasPiece = false;
    } else {
        // Select the piece that the user clicked on...
        hasPiece = true; // but only when the user clicked on a valid piece ;)
    }
}