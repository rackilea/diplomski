public static void addCell
   (String  excelCell,
    int     rowIdx,
    boolean ignoreCase,
    Integer defCellValue,
    List<PairT<Integer, Integer>> columnList)
{
    Integer cellValue;
    try {
        cellValue = Integer.valueOf(excelCell);
    } catch (NumberFormatException x) {
        cellValue = defCellValue;
    }
    columnList.add(new PairT<>(cellValue, rowIdx));
}

// addCell overload with Double defCellValue
// addCell overload with String defCellValue