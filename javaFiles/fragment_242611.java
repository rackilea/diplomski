int i = 1;
for (pegawai p : list_pegawai) {
     Row row2 = sheet.createRow(i++);
     row2.createCell(0).setCellValue(p.getName());
     row2.createCell(1).setCellValue(p.getAddress());
     row2.createCell(2).setCellValue(p.getPh());
 }