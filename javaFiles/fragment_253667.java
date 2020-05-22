Cell name = sheet.getCell(0, 0);
Cell name1 = sheet.getCell(1, 0);
Cell value = sheet.getCell(0, 1);
Cell value1 = sheet.getCell(1, 1);

System.out.println(sheet.getRows());      //4
System.out.println(sheet.getColumns());   //2
System.out.println(name.getContents());   //Name
System.out.println(name1.getContents());  //Value
System.out.println(value.getContents());  //A
System.out.println(value1.getContents()); //1