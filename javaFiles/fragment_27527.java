/**For drawing arrows between cells to clarify workflow.
             */
            @Override
            protected void paintComponent(Graphics g){

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(2));

                //draw arrows
                for (int i = 0; i < getRowCount() - 1; i++)
                {
                    // -- draw arrow between A,B columns --
                    // stem
                    Rectangle cell = getCellRect(i, 0, false); // cell.x , y = top left corner coords. of rectangle
                    int outReach = 5; //length to go from paint starting point
                    Point center = new Point(cell.x + cell.width, cell.y + cell.height); //bottom right corner of cell
                    Point sw = new Point(center.x - outReach, center.y + outReach); //go southwest. remember x++ is right, y++ is down
                    Point ne = new Point(center.x + outReach, center.y - outReach); //go northeast
                    g2.setColor( Color.BLACK);
                    g2.drawLine(sw.x, sw.y, ne.x, ne.y);

                    //now the arrow tip starting from (sw.x, sw.y) - upper part here
                    outReach = 6;
                    center = new Point(sw.x, sw.y);
                    Point north = new Point(center.x, center.y - outReach); 
                    g2.drawLine(center.x, center.y, north.x, north.y);

                    //lower part of arrow tip
                    Point e = new Point(center.x + outReach, center.y); //east
                    g2.drawLine(center.x, center.y, e.x, e.y);


                    // -- X,Y columns --
                    cell = getCellRect(i, 2, false);
                    outReach = 5; 
                    center = new Point(cell.x + cell.width, cell.y + cell.height); //bottom right corner of cell
                    Point nw = new Point(center.x - outReach, center.y - outReach); 
                    Point se = new Point(center.x + outReach, center.y + outReach); 
                    g2.drawLine(nw.x, nw.y, se.x, se.y);

                    //horizontal tip (above other part)
                    outReach = 6;
                    center = new Point(nw.x, nw.y);
                    e = new Point(center.x + outReach, center.y ); 
                    g2.drawLine(center.x, center.y, e.x, e.y);

                    //vertical tip (lower)
                    Point south = new Point(center.x, center.y + outReach);
                    g2.drawLine(center.x, center.y, south.x, south.y);

                }
            }// end paintComponent()