private void expand(RasterPoint currentPoint)
    {
//      this.watchedRasterPoints.add(currentPoint);
        for(RasterPoint point : currentPoint.getSuccessorPoints(this.raster, this))
        {
//          this.watchedRasterPoints.add(point);
            // wenn der Nachfolgeknoten bereits auf der Closed List ist - tue nichts
            if(this.closedList.contains(point) || point.isWall())
            {
            }
            else
            {
                // g Wert für den neuen Weg berechnen: g Wert des Vorgängers plus
                // die Kosten der gerade benutzten Kante
                int gValue = currentPoint.getgValue() + 1;
                // wenn der Nachfolgeknoten bereits auf der Open List ist,
                // aber der neue Weg nicht besser ist als der alte - tue nichts
                if(this.openlist.contains(point) && gValue >= point.getgValue())
                {
                }
                else
                {
                    // Vorgängerzeiger setzen und g Wert merken
                    point.setPreRasterPoint(currentPoint);
                    point.setgValue(gValue);
                    // f Wert des Knotens in der Open List aktualisieren
                    // bzw. Knoten mit f Wert in die Open List einfügen
                    point.setfValue(gValue+point.calcHValue(this.endPoint));
                    if(this.openlist.contains(point))
                    {
                        int position = this.openlist.indexOf(point);
                        this.openlist.set(position, point);
                    }
                    else
                    {
                        floor.getModel().controller.drawRasterRect(point.getRasterX(), point.getRasterY(), Color.CYAN);
                        this.openlist.add(point);
                    }
                }
            }
        }