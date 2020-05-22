private void expandConditionalFormatting(XSSFCell cell, XSSFCell styleCell){
      XSSFSheetConditionalFormatting xscf = cell.getSheet().getSheetConditionalFormatting();
      for(int idx = 0;idx<xscf.getNumConditionalFormattings();idx++){
         XSSFConditionalFormatting cf = xscf.getConditionalFormattingAt(idx);
         List<CellRangeAddress> cra = Arrays.asList(cf.getFormattingRanges());
         List<CellRangeAddress> newCra = new ArrayList();
         for(CellRangeAddress c:cra){
            if(containsCell(c, styleCell) && !containsCell(c,cell)){
               newCra.add(new CellRangeAddress(Math.min(c.getFirstRow(), cell.getRowIndex()),Math.max(c.getLastRow(),cell.getRowIndex()),Math.min(c.getFirstColumn(), cell.getColumnIndex()),Math.max(c.getLastColumn(),cell.getColumnIndex())));
            } else{
               newCra.add(c);
            }
         }
         ArrayList<XSSFConditionalFormattingRule> cfs = new ArrayList();
         for(int ci=0;ci<cf.getNumberOfRules();ci++){
            cfs.add(cf.getRule(ci));
         }

         xscf.addConditionalFormatting(newCra.toArray(new CellRangeAddress[newCra.size()]),cfs.toArray(new XSSFConditionalFormattingRule[cfs.size()]));
         xscf.removeConditionalFormatting(idx);
      }
   }
   private boolean containsCell(CellRangeAddress cra, Cell cell){
      if(cra.getFirstRow()<=cell.getRowIndex() && cra.getLastRow()>=cell.getRowIndex()){
         if(cra.getFirstColumn()<=cell.getColumnIndex() && cra.getLastColumn()>=cell.getColumnIndex()){
            return true;
         }
      }
      return false;
   }