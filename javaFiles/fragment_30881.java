Iterator<Row> iterator = firstSheet.iterator();
while (iterator.hasNext()){
         Row nextRow = iterator.next();
         Iterator<Cell> cellIterator = nextRow.cellIterator(); 
         int id = (int) cellIterator.next().getNumericCellValue();
         int pr = (int) cellIterator.next().getNumericCellValue();
         int[] prId = new int[2];

         prId[0] = (int) cellIterator.next().getNumericCellValue();

         nextRow = iterator.next(); // i have to move down one row to get 5 and 6
         cellIterator = nextRow.cellIterator();
         cellIterator.next();   // for first empty cell
         cellIterator.next();   // for second empty cell

         precId[1] = (int) cellIterator.next().getNumericCellValue();
         int co = (int) cellIterator.next().getNumericCellValue();
         list.add(new Rule(id, pr, prId, co));

    }