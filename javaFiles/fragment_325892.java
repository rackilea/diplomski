@Override
 protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       if (drawingLock.tryLock()) {
            try {
                 Graphics2D g2 = (Graphics2D) g;
                 if (baseImage != null) {                        
                       g2.drawImage(baseImage, imageOrigin.x, imageOrigin.y, null);
                 }
                 if (this._Drawing != null) {
                       if (this.poly != null && this._Drawing == Drawings.Polygon) {                             
                            //g.setColor(Color.gray);
                            g2.fillPolygon(this.poly.xPoints, this.poly.yPoints, this.poly.xPoints.length);
                       }
                       if (this.rect != null && this._Drawing == Drawings.Rectangle) {
                            //g.setColor(Color.gray);
                            g2.fillRect(rect.x, rect.y, rect.width, rect.height);
                       }
                       if (this.rect != null && this._Drawing == Drawings.Oval) {
                            //g.setColor(Color.gray);
                            g2.fillOval(rect.x, rect.y, rect.width, rect.height);
                       }
                       if (this.ln != null && this._Drawing == Drawings.Line) {
                            //g.setColor(Color.black);
                            g2.drawLine(ln._x1, ln._y1, ln._x2, ln._y2);
                       }
                 }                    
            } finally {
                 drawingLock.unlock();
            }
       }
 }