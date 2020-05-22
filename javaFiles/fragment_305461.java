List<String> cellValues = new ArrayList<String>();
while(cellIterator.hasNext()) 
     {
    Cell cell1 = cellIterator.next();

    switch(cell1.getCellType()) 
       {
         case Cell.CELL_TYPE_STRING:
         String strval = cell1.getStringCellValue();
         cellValues.add(strval);
         break;
       }
                  }
         }
    }
request.settAttribute("Values2", cellValues);