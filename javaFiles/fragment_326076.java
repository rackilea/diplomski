JSONArray productOffersList=drawerdatas.getJSONArray("productOffersList");

offertextlist=new ArrayList<ProductOffersModel>(); 
// You were re creating the list array list inside the for loop so you were losing the data from the 1st product.
for(int k=0;k<productOffersList.length();k++)
{

   JSONObject joofer = productOffersList.getJSONObject(k);
   JSONArray offerLine=joofer.getJSONArray("offerLine");

   for(int l=0;l<offerLine.length();l++)
   {
      JSONObject jooferline = offerLine.getJSONObject(l);
      ProductOffersModel pom=new ProductOffersModel();
      pom.setProductOffers_text(jooferline.getString("text"));
      pom.setProductOffers_colorA(jooferline.getString("colorA"));
      offertextlist.add(pom);
   }

}
if(offertextlist !=null && offertextlist.size()==4)
{
   product_view_offertextfirst.setText(offertextlist.get(0).getProductOffers_text()
                      + " " + offertextlist.get(1).getProductOffers_text());
   product_view_offertexttwo.setText(offertextlist.get(2).getProductOffers_text()
                      + " " + offertextlist.get(3).getProductOffers_text());
}