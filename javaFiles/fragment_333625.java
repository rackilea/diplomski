public class MyTable implements ITable {
   long[][] table;
   public MyTable(int r, int c) {
      table = new long[r][c];
   }
   void set(Cell cell, long value) {
        table[cell.getRow()][cell.getColumn()] = value;
   }
   long get(Cell cell) {
        return table[cell.getRow()][cell.getColumn()];
   }       
   long sum(Cell fromCell, Cell toCell) {
        long sum = 0;
        for(int r = fromCell.getRow(); r <= toCell.getRow(); r++) {
            for(int c = fromCell.getColumn(); c <= toCell.getColumn(); c++) {
                sum += table[r][c];
            } 
        }
        return sum;
   }
   long avg(Cell fromCell, Cell toCell) {
        long num = 0;
        long sum = 0;
        for(int r = fromCell.getRow(); r <= toCell.getRow(); r++) {
            for(int c = fromCell.getColumn(); c <= toCell.getColumn(); c++) {
                sum += table[r][c];
                num++;
            } 
        }
        return sum/num;
   }
}