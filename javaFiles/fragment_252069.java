for (int i=0;i<burstCellGrid.size();i++){
            System.out.println("i : " + i);
            System.out.println("burstCellGrid.get(i).getColCoordinate() : " + burstCellGrid.get(i).getColCoordinate());
            System.out.println("burstCellGrid.get(i).getRowCoordinate() : " + burstCellGrid.get(i).getRowCoordinate());
            points[i] = new Vector2(burstCellGrid.get(i).getColCoordinate(),burstCellGrid.get(i).getRowCoordinate()) ;
        }