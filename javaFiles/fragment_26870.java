interface MyCellTableStyle extends CellTable.Style {}
interface TableResources extends CellTable.Resources {
  @Override
  @Source(value = {CellTable.Style.DEFAULT_CSS, "CellTablePatch.css"})
  MyCellTableStyle cellTableStyle();
}