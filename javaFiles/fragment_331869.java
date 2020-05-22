class Block extends Rectangle {
    public int groundID;
    public int airID;
    Window window; 

    public Block (int x, int y, int width, int height, int groundID, int airID, Window window) {
        setBounds (x, y, width, height);
        this.groundID = groundID;
        this.airID = airID;
        this.window = window;
    }
    public void draw (Graphics g) {
        g.drawImage (window.tileset_ground [groundID], x, y, width, height, null);
        if (airID != Value.airAir) {
            g.drawImage (window.tileset_air [airID], x, y, width, height, null);
        }
    }
}