//GET THE FONTMETRICS
        FontMetrics fm = h2.getFontMetrics();
        //GET THE DIAMETER OF THE HOLE
        double hEdge = (UnitConvert.pixelsToMeters(hole.getDiameter()));
        // GET THE LOCATION OF THE HOLE
        double x1 =((hole.getEasting() - bounds.getX()));
        double y1 = (bounds.getHeight() + bounds.getY() - hole.getNorthing());
        //SET THE COLOUR OF THE TEXT
        h2.setColor(AMETHYST);
        //SET THE FONT TO USE
        h2.setFont(new Font("Monaco", Font.BOLD, 8));
        //USING - DRAWGLYPHVECTOR() TO OVERCOME THE PRINTING ISSUE RELATED TO THE OSX PORT OF JAVA7 - MAY NOT NEED THIS WITH FUTURE UPDATES.
        h2.drawGlyphVector(
                h2.getFont().createGlyphVector(h2.getFontRenderContext(), 
                dec1P.format(hole.getHoleLength())),
                (int)((x1+hEdge*Math.cos(300))*scale)- (fm.stringWidth(dec1P.format(hole.getHoleLength()))/2),  
                (int)((y1 + (hEdge *enhance*1.1)/2)*scale) +(fm.getHeight()/2) +pixelOffset
                );

        /*//USING - DRAWSTRING() DOESN'T WORK IN JAVA 7 ON MAC OSX
        h2.drawString(
                (dec1P.format(hole.getHoleLength())),   
                (int)((x1+hEdge*Math.cos(300))*scale)- (fm.stringWidth(dec1P.format(hole.getHoleLength()))/2),  
                (int)((y1 + (hEdge *enhance*1.1)/2)*scale) +(fm.getHeight()/2) +pixelOffset
                );
*/