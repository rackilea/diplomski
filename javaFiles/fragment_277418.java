totalamoutdue.add(null); //will insert at the end, i.
for(int j = rowAccNo1+1; j < row.getRowNum(); j++){
      srcaccno = formatter.formatCellValue(sheet.getRow(j).getCell(0));
      if(accno.get(i).contains(srcaccno)){
              totalamt = formatter.formatCellValue(sheet.getRow(j).getCell(10)); //No need to get the value if it is not the account you want
              totalamountdue.set(i, totalamt);
              break; //Break the current for loop, IF there is no need to read further
      }
  }