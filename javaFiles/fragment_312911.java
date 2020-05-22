if (c != null)
          {
            toSheet.addCell(c);

            // Cell.setCellFeatures short circuits when the cell is copied,
            // so make sure the copy logic handles the validated cells
            if (c.getCellFeatures() != null &
                c.getCellFeatures().hasDataValidation())
            {
              validatedCells.add(c);
            }
          }