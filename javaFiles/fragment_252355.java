@Override
    public void keyPressed(KeyEvent K) {
       /* .. many lines omitted .. */
       showStatus("Typed : "+s);
       repaint(); // <<- this line is missing!
    }