int orderNo = Integer.parseInt(table.getPropertyAsString("Order_No"));
   int freightRate = Integer.parseInt(table.getPropertyAsString("Freight_Rate"));
   int marginPercent = Integer.parseInt(table.getPropertyAsString("Margin_Percent"));

   int[] ord = new int[orderNo];
   int[] frei = new int[freightRate];
   int[] margin = new int[marginPercent];


 // whatever you do with these values

   txt_1.setText(ord);
   txt_1.setText(frei);
   txt_1.setText(margin);