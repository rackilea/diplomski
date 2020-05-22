public void mapUpdate() {
    Graphics2D g = terrain.createGraphics();
    try {
        g.setComposite(AlphaComposite.DstIn); // Porter-Duff "destination-in" rule
        g.drawImage(terrainMask); // Clear out transparent parts from terrainMask
    }
    finally {
         g.dispose();
    }
}