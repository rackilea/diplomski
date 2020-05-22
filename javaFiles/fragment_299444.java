int i = jTable1.getRowCount()-1;
double icost = (double) tableSale.getModel().getValueAt(i, 2);
System.out.println(icost);

//calculating Gross Total  
double grosstotal = (sellingqty * icost) - idiscount;

System.out.println(grosstotal);

//setting qty input value to table sale  
tableSale.getModel().setValueAt(sellingqty, i, 3);
//setting input value to table sale  
tableSale.getModel().setValueAt(idiscount, i, 4);
//setting grosstotal value to table sale
tableSale.getModel().setValueAt(grosstotal, i, 5);