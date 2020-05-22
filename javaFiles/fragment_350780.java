public void onClick(View v) 
{
   Toast.makeText(v.getContext(), "Doing Closing Cost Breakdown", Toast.LENGTH_SHORT);

   float fPrice, fRate;

   try
   {
      fPrice = Float.parseFloat(priceText.getText().toString());
      fRate = Float.parseFloat(rateText.getText().toString());

      float fRealEsate = fPrice * fRate;
      Toast.makeText(v.getContext(), "Real Estate Brokerage Fee: " 
         + fRealEsate, Toast.LENGTH_SHORT).show();
   }
   catch (NumberFormatException nfe)
   {
      Toast.makeText(v.getContext(), 
         "Please enter numeric values for Price and Rate.", 
         Toast.LENGTH_SHORT).show();
   } 
}