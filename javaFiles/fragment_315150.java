private void createListenerURL(){
   URL url = new URL(urlPath);
   InputStream inputStream = url.openStream();

   // geting all data from URL and addig in table row like this:

   new Thread(new Runnable() {
     @Override
     public void run() {

         while (1==1){
           try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                         TableLayout tableLayout=(TableLayout)findViewById(R.id.tabeldisplay);

                         final TableRow tr=new TableRow(this);
                         tr.setId(i);
                         tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

                         TextView textview=new TextView(this);
                         textview.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
                         textview.setText(data.getProductName().get(i));
                         textview.setTextSize(fontSizeTabel);
                         textview.setTextColor(Color.parseColor("#010101"));

                         tr.addView(textview);
                         tableLayout.addView(tr);
                         }
                });
              } catch (InterruptedException e) {
                 e.printStackTrace();
              }

          try {
              Thread.sleep(refreshRateURL);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
         }
      }).start();
 }