for (Iterator<Coordinates> it = listOfDrawing.iterator(); it.hasNext();){
                Coordinates x = it.next();
                if (x.vrstaCrtanja == 1) {
                     it.drawLine(x.x1,x.y1,x.x2,x.y2,drawing.p);
                }
            }