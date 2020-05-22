private static Set<ExcelRangeBordersFlag> getBordersFlag(
      boolean bottom, boolean top, boolean left, boolean right){
    ExcelRangeBordersFlag results = EnumSet.noneOf(ExcelRangeBordersFlag.class); 

    if (bottom){
        results.add(ExcelRangeBordersFlag.BORDER_BOTTOM);
    }

    if (top){
        results.add(ExcelRangeBordersFlag.BORDER_TOP);
    }

    if (left){
        results.add(ExcelRangeBordersFlag.BORDER_LEFT);
    }

    if (right){
        results.add(ExcelRangeBordersFlag.BORDER_RIGHT);
    }

    System.out.println(results);

    return results;
}