public static void addCell
   (String  excelCell,
    int     rowIdx,
    boolean ignoreCase,
    Integer defCellValue,
    List<PairT<Integer, Integer>> columnList)
{
    addCell(excellCell,
            rowIdx,
            ignoreCase,
            defCellValue,
            columnList,
            Integer::valueOf);
}

public static void addCell(..., Double defCellValue, ...) {
    addCell(..., Double::valueOf);
}

public static void addCell(..., String defCellValue, ...) {
    addCell(..., Function.identity());
}

private static <T> void addCell
   (String  excelCell,
    int     rowIdx,
    boolean ignoreCase,
    T       defCellValue,
    List<PairT<T, Integer>> columnList,
    Function<String, T>     cellParser)
{
    if (ignoreCase) {
        excelCell = excelCell.toUpperCase();
    }
    T cellValue;
    try {
        cellValue = cellParser.apply(excelCell);
    } catch (IllegalArgumentException x) {
        cellValue = defValue;
    }
    columnList.add(new PairT<>(cellValue, rowIdx));
}