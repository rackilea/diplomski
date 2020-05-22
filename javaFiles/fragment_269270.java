boolean addWhereClause; 
QAddress address = QAddress.address; 
JPQLQuery query = new JPAQuery(getEntityManager()); 
query.from(address);    
if (addWhereClause) {
    query.where(address.company.isNotNull());
}