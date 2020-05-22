void trans() throws IOException {
   while (trans != 0) {
   System.out.print("Enter Transaction Number: ");
   trans = Integer.parseInt(stdin.readLine());

   if (trans == 0) {
     outputSalesData();
     empTotal = 0;
     empBonus = 0;
     ytdSales = 0;
   } else {
     System.out.print("Enter Transaction Type: ");
     type = stdin.readLine();
     System.out.print("Enter Transaction Amount: ");
     amount = Double.parseDouble(stdin.readLine());
     // ... processing ...
     outputUpdate();
     calcSalesData();
     tCount++;
   }
 }
}