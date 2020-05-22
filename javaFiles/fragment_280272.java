...
   //set width to n character widths = count characters * 256
   int widthUnits = 20*256;
   sheet.setColumnWidth(1, widthUnits);

   //set height to n points in twips = n * 20
   short heightUnits = 60*20;
   cell.getRow().setHeight(heightUnits);
...