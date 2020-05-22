boolean isEmptyRow = false;
            int cellCount = 0;
            int nullCount = 0;

                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    cellCount++;
                    Cell cell = (Cell) cellIterator.next();
                    if ((cell == null)
                            || ((cell != null) && (cell.getCellType() == Cell.CELL_TYPE_BLANK))) {
                        nullCount++;
                    }
                }

            if ((cellCount != 0) && (nullCount != 0)
                    && (cellCount == nullCount)) {        //If nullCount & cellCouont are same, Row is empty
                isEmptyRow = true;
            }