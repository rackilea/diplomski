// Store the original transform
AffineTransform oldAT = g2D.getTransform();

for(int x=0;x<(int) l.width;x++){
    for(int y=0;y<(int) l.height;y++){
        if((x*32+((int)offset.getX())+32)*scale>=0 && (x*32+32+((int)offset.getX())-32)*scale<=getWidth() && (y*32+((int)offset.getY())+32)*scale>=0 && (y*32+((int)offset.getY())-32)*scale<=getHeight()){
            Tile t = tiles.getTileById(l.levelData[x][y].getId());

            // Apply the rotation to the g2D directly
            g2D.rotate((Math.PI/2)*l.levelData[x][y].getRotation(), (x*32+16+((int)offset.getX()))*scale, (y*32+16+((int)offset.getY()))*scale);
            g2D.drawImage(t.getImage(), (x*32+((int)offset.getX()))*scale, (y*32+((int)offset.getY()))*scale, (x*32+32+((int)offset.getX()))*scale, (y*32+32+((int)offset.getY()))*scale, 0, 0, 32, 32, null);

            // "Undo" the rotation by restoring the original transform
            g2D.setTransform(oldAT);
            for(OverlayData overlay:l.levelData[x][y].getOverlayData()){
                Tile t2= tiles.getTileById(overlay.getId());
                int corner = overlay.isCorner()? 1 : 0;
                if(t2.hasImage){
                    g2D.drawImage(t2.getOverlayImage(), (x*32+((int)offset.getX()))*scale, (y*32+((int)offset.getY()))*scale, (x*32+32+((int)offset.getX()))*scale, (y*32+32+((int)offset.getY()))*scale, overlay.getMod()*32, corner*32, overlay.getMod()*32+32, corner*32+32, null);
                }
            }
        }
    }
}

// Finally, restore the original transform again
g2D.setTransform(oldAT);