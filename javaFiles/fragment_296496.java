if (valueCell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                switch (valueCell.getCachedFormulaResultTypeEnum()) {
                   case STRING:
                       values.put(valueHeader,"");
                       break;
                      case NUMERIC:
                          if (valueCell.getCellStyle().getDataFormatString().contains("%")) {
                                // Detect Percent Values
                                  values.put(valueHeader, String.valueOf(Double.valueOf(valueCell.getNumericCellValue() * 100).intValue()) + "%");

                            }else{
                          values.put(valueHeader,String.valueOf(valueCell.getNumericCellValue()));
                            }
                       break;
                      case ERROR:
                          values.put(valueHeader,"");
                       break;
                      default:
                       System.out.println("default"); //should never occur
                     }
                     }