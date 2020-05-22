private Affiliate validateAffiliate(Affiliate affiliate) {
   this.affiliate=affiliate;
   if(affiliate!=null){
   AffiliateDAO afd=new AffiliateDAO();

   // This was causing NPE. Data source must be set before using it.
   afd.setDataSource(passDataSourceInstance);

   afd.insertAffiliate(affiliate);
}