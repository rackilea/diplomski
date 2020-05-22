Row r1 = Correlation.corr(output, "intensity").head();
Matrix r2= r1.getAs(0);
   for (int i = 0; i < r2.numRows(); i++) {
       for (int j = 0; j < r2.numCols(); j++) {
            System.out.print(r2.apply(i,j)+"  ");
       }
       System.out.println();
   }