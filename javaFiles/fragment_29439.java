public List<Kennel> getAllKennels(){
   try{
        // name of the desired NamedQuery to run should be given 
        Query queryStr = this.entityManager
            .createNamedQuery("Dog.getAllKennelsInAgeOrder");             
        List<Kennel> kennels =  queryStr.getResultList();

        if(null != kennels && !kennels.isEmpty()){
            return kennels;
        } else {
            return Collections.emptyList();
        }
    } catch (Exception e) {
        LOGGER.error("Exception Occcured in getAllKennels ", e);
    }
}