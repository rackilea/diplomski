public List<String> removeTripObject( List<String> tripIds ) {
    Query query = Query.query( Criteria.where( "tripGcsId" ).in( tripIds ) );
    Update update = new Update().pull("trips", query );
    getMongoTemplate().updateMulti( new Query(), update, "ORDER" );
    return updatedOrders;
}