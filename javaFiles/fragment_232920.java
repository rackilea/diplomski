newCellStyle = newCell.getSheet().getWorkbook().createCellStyle();
          newCellStyle.cloneStyleFrom(oldCellStyle);
          //          newCellStyle.getCoreXf().unsetBorderId();
          //          newCellStyle.getCoreXf().unsetFillId();
          StylesTable newStylesSource = newCell.getSheet().getWorkbook().getStylesSource();
          StylesTable oldStylesSource = oldCell.getSheet().getWorkbook().getStylesSource();
          for (XSSFCellFill fill : oldStylesSource.getFills())
          {
            XSSFCellFill fillNew = new XSSFCellFill(fill.getCTFill());
            newStylesSource.putFill(fillNew);
          }
          for (XSSFCellBorder border : oldStylesSource.getBorders())
          {
            XSSFCellBorder borderNew = new XSSFCellBorder(border.getCTBorder());
            newStylesSource.putBorder(borderNew);
          }