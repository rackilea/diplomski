public List<DomainObject> read(){
  return fetchDataFromDb();
}

private synchronized List<DomainObject> fetchProductAssociationData(){
  //read your chunk-size of records from database which has status as 'NOT PROCESSED' 
  and change the status of the data which is read to 'IN PROGRESS'
  return list;
}