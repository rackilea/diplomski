if (DateUtil.isCellDateFormatted(cell)) {
                double val = cell.getNumericCellValue();
                Date date = HSSFDateUtil.getJavaDate(val);
                String dateFmt = null;

                if(cell.getCellStyle().getDataFormat()==14){
                    dateFmt = "dd/mm/yyyy";
                    value = new CellDateFormatter(dateFmt).format(date);
                }
                else{
                    DataFormatter fmt = new DataFormatter();
                    String valueAsInExcel = fmt.formatCellValue(cell);
                    value = valueAsInExcel;
                }
           }