...
  Set<Integer> toRemoveSet = new HashSet<Integer>();
  toRemoveSet.add(sheet.getRow(0).getRowNum());
  toRemoveSet.add(sheet.getRow(2).getRowNum());
  toRemoveSet.add(sheet.getRow(4).getRowNum());
  toRemoveSet.add(sheet.getRow(2).getRowNum());

  System.out.println(toRemoveSet); // does not contain the row index 2 two times

  for (Integer rowNum : toRemoveSet) {
   Row row = sheet.getRow(rowNum);
   System.out.println(row.getRowNum());
   sheet.removeRow(row);
  }
...