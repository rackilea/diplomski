public static void copyCell(HSSFCell oldCell, HSSFCell newCell, Map<Integer, HSSFCellStyle> styleMap) {   
      if(styleMap != null) {   
          if(oldCell.getSheet().getWorkbook() == newCell.getSheet().getWorkbook()){   
              newCell.setCellStyle(oldCell.getCellStyle());   
          } else{   
              int stHashCode = oldCell.getCellStyle().hashCode();   
              HSSFCellStyle newCellStyle = styleMap.get(stHashCode);   
              if(newCellStyle == null){   
                  newCellStyle = newCell.getSheet().getWorkbook().createCellStyle();   
                  newCellStyle.cloneStyleFrom(oldCell.getCellStyle());   
                  styleMap.put(stHashCode, newCellStyle);   
              }   
              newCell.setCellStyle(newCellStyle);   
          }   
      }   
      switch(oldCell.getCellType()) {   
          case HSSFCell.CELL_TYPE_STRING:   
              newCell.setCellValue(oldCell.getStringCellValue());   
              break;   
        case HSSFCell.CELL_TYPE_NUMERIC:   
              newCell.setCellValue(oldCell.getNumericCellValue());   
              break;   
          case HSSFCell.CELL_TYPE_BLANK:   
              newCell.setCellType(HSSFCell.CELL_TYPE_BLANK);   
              break;   
          case HSSFCell.CELL_TYPE_BOOLEAN:   
              newCell.setCellValue(oldCell.getBooleanCellValue());   
              break;   
          case HSSFCell.CELL_TYPE_ERROR:   
              newCell.setCellErrorValue(oldCell.getErrorCellValue());   
              break;   
          case HSSFCell.CELL_TYPE_FORMULA:
              newCell.setCellType(HSSFCell.CELL_TYPE_FORMULA); //Add this line
              newCell.setCellFormula(oldCell.getCellFormula());   
              break;   
          default:   
              break;   
      } 
}