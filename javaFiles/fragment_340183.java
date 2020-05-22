for (Integer id : siteID){ 
       site = em.find(SiteTable.class, id);
       if(site != null && site.getPostcode() != null && !site.getPostcode().equals("")){
           XMLPositionRetriever.runXMLQuery(site.getPostcode()); 
       }
          else{
           System.out.println("The site and/or postcode against this Instruction does not exist.");
       }
}