public class Product extends SuperBottomSheetFragment, UpdateTextCallback {
 ...
 ..
 .
class ExecuteOnBack extends AsyncTask<Void,Void,Void>{
 ..
 .

    @Override
    protected Void doInBackground(Void... voids) {
     ...
     ..
     .
     adapter = new variationAdapter(data, Product.this);
            variationRecycler.setAdapter(adapter);
     ...
     ..
     .
  }
 }
 ...
 .. 
 . 
  public void updateText(String text) {
   TextView tv = findViewById(R.id.productPricePopUp);
   tv.setText(s);
   System.out.println("Rohit " + tv.getText());
  }

}