PdfPTable table = new PdfPTable(2);
Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
PdfPCell c1 = new PdfPCell(new Phrase("Earning Description"),font);
c1.setHorizontalAlignment(Element.ALIGN_CENTER);
table.addCell(c1);

c1 = new PdfPCell(new Phrase("Earning Amount"),font);
c1.setHorizontalAlignment(Element.ALIGN_CENTER);
table.addCell(c1);

      // Here's how you adding the values 
for(int i=0;i<listEarnings.size();i++){



         String temp1 = listEarnings.get(i).getEarningsDescription();
         String temp2 =listEarnings.get(i).getEarningsAmount();


         if(temp.equalsIgnoreCase("")){
             temp="*"; // this fills the cell with * if the String is empty otherwise cell won't be created
         }

         if(temp2.equalsIgnoreCase("")){
            temp2="*"; // this fills the cell with * if the String is empty otherwise cell won't be created
          }
table.addCell( temp1  ); // rows for first column
table.addCell(temp2);  // rows for seconds column

}