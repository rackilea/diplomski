public boolean checkAndPrintReport(){ 
   for(int i=0; i<9; i++)
        if(!isGoodRow(i) || !isGoodColumn(i) || !isGoodBlock(i/3, i%3)
            return false;
   return true;
}