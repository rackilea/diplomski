CellStyle dateStyle = wb.createCellStyle();
DataFormat df = wb.createDataFormat();
dateStyle.setDataFormat(df.getFormat("dd.mm.yyyy"));
...
case "java.sql.Timestamp":
{
  cell.setCellStyle(dateStyle);
  cell.setCellValue(new Date(((Timestamp) o).getTime()));
  break;
}