for(Product p: md.takeAllProducts()){
         //create new row
         TableRow tableRow =  new TableRow(this);

         // create new text view
         TextView textView1 = new TextView(this);
         textView1.setText(p.getProductCode());
         //add to row
         tableRow.addView(textView1);

         //create another text view and add to same row
         TextView textView2 = new TextView(this);
         textView2.setText(p.getProductName());
         tableRow.addView(textView2);

         //
         TextView textView3 = new TextView(this);
         textView3.setText(p.getQuantity());
         tableRow.addView(textView3);

         //
         TextView textView4 = new TextView(this);
         textView4.setText(p.getExpireDate());
         tableRow.addView(textView4);
}