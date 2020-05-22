private static boolean biggerThan100(ArrayList<HSSFCell> list) {
  return list.get(3).getCellType() == Cell.CELL_TYPE_NUMERIC &&
      (Integer.parseInt(list.get(3).getStringCellValue()) > 100);
}

public static ArrayList<ArrayList<HSSFCell>> newTogether(ArrayList<ArrayList<HSSFCell>> sheetData) {
  ArrayList<ArrayList<HSSFCell>> temp = new ArrayList<>(sheetData);
  Collections.sort(temp, new Comparator<ArrayList<HSSFCell>>() {
      public int compare(ArrayList<HSSFCell> a, ArrayList<HSSFCell> b) {
        if(biggerThan100(a) && !biggerThan100(b)) return -1;
        else if(biggerThan100(b) && !biggerThan100(a)) return 1;
        else return 0;
      }
  });
  return temp;
}