TextColumnBuilder<Date> column = col.column(title,  name,  type.dateType());
if (res.getLocale().equals("EN") {
  column.setPattern("dd.MM.yyyy");
}
else if (res.getLocale().equals("US") {
  column.setPattern("MM/dd/yyyy");
}
else {
   ...
}
rep.addColumn(column);