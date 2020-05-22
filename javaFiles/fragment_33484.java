WritableCellFormat wcf1=new WritableCellFormat(new  jxl.write.NumberFormat("#.###############"));
         wcf1.setShrinkToFit(true);
        try
         {
                   for(int i=0;i<=numberOfNeurons[0];i++)
         {
                          for(int j=0;j<numberOfNeurons[1];j++)
            {
               number = new Number(0,rowno1,wtofnetwork[i][j],wcf1);

    sheet.addCell(number);
            rowno1++;

            }
             }