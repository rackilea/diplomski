/**
     * @param locationRow
     */
    private void updateSheetReferences(int locationRow, boolean insertingNewRow) {
        System.out.printf("\n%s ms elapsed updateSheetReferences \n", System.currentTimeMillis() - startTime);
        Pattern cellRefPattern = Pattern.compile("R(\\[?)([-0-9]+)\\]?C(\\[?)([-0-9]*)\\]?");
          int incDirection = 1;
          if (insertingNewRow == false)  incDirection = -1;
          for(AppCell nextCell : activeWorksheetCells.getAllCells()) {
              int row = nextCell.row;
              int col = nextCell.col;
              String cellInputValue = nextCell.inputValue;
              if (cellInputValue == null) continue;


              // create a copy of the cell to replace
              String updateReference = cellInputValue; 

              if(updateReference.startsWith("=")) {
                  String removeReferenceBug = updateReference.replace( (CharSequence) "C:R", (CharSequence) "C[0]:R");


                  Matcher referenceMatcher = cellRefPattern.matcher(removeReferenceBug);
                  StringBuffer restultBuffer = new StringBuffer();
                  while (referenceMatcher.find()) {
                      try {
                          if(referenceMatcher.group(1).equals("[")) {
                              int rowOffset = Integer.parseInt(referenceMatcher.group(2));
                              int topRowOfSpan;
                              int bottomRowOfSpan;                                
                              int incSize = 1*incDirection;
                              // the location of the deleted row is relative, and so one row lower if row was deleted
                              int locationDeletedOffset = 0;
                              if(row >= locationRow && insertingNewRow == false) locationDeletedOffset = -1; 

                              // get the top and bottom rows of the 
                              if(rowOffset > 0) {
                                  topRowOfSpan = row;
                                  bottomRowOfSpan = row + rowOffset;
                              } else {
                                  topRowOfSpan = row + rowOffset;
                                  bottomRowOfSpan = row ;       
                                  incSize = -1*incDirection;
                              }                               
                              //System.out.println("move down: reference:"+cellAddr.reference+" topRowOfSpan:"+topRowOfSpan+
                              //      " insertLocationRow:"+insertLocationRow+" bottomRowOfSpan:"+bottomRowOfSpan);
                              // IF reference is the deleted row 
                              if(insertingNewRow == false && row + rowOffset == locationRow+locationDeletedOffset) {
                                  referenceMatcher.appendReplacement(restultBuffer, "{}");                                                                                                                    
                              } else {
                                  if(topRowOfSpan <= locationRow+locationDeletedOffset && bottomRowOfSpan >= locationRow+locationDeletedOffset) rowOffset += incSize;
                                  if(referenceMatcher.group(3).equals("[")) {
                                      referenceMatcher.appendReplacement(restultBuffer, "R["+rowOffset+"]C["+referenceMatcher.group(4)+"]");                                      

                                  } else {
                                      int colOffset = 0;                                          
                                      String colText = referenceMatcher.group(4);                                         
                                      if(colText != null && "".equals(colText) == false) {
                                          colOffset = Integer.parseInt(colText) - col;
                                      }                                       
                                      referenceMatcher.appendReplacement(restultBuffer, "R["+rowOffset+"]C["+colOffset+"]");                                                                              
                                  }                                   
                              }
                          } else {
                              int absoluteRow = Integer.parseInt(referenceMatcher.group(2));
                              // IF reference is the deleted row
                              if(insertingNewRow == false && absoluteRow == locationRow) {
                                  referenceMatcher.appendReplacement(restultBuffer, "{}");                                                                                                                    
                              } else {
                                  if(absoluteRow >= locationRow ) absoluteRow += 1 * incDirection;
                                  if(referenceMatcher.group(3).equals("[")) {
                                      referenceMatcher.appendReplacement(restultBuffer, "R"+absoluteRow+"C["+referenceMatcher.group(4)+"]");                                                                                                              
                                  } else {
                                      referenceMatcher.appendReplacement(restultBuffer, "R"+absoluteRow+"C"+referenceMatcher.group(4));                                                                                                                                                   
                                  }
                              }

                          }
                      } catch(NumberFormatException nfe) {}
                  } // END while
                  referenceMatcher.appendTail(restultBuffer);
                  updateReference = restultBuffer.toString();                                                                         

              } // END IF

              nextCell.inputValue =  updateReference;
          }
    }