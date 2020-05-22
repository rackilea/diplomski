StringBuilder sql = new StringBuilder();

sql.append("SELECT *");
sql.append(", ( SQRT( POW( 69.1 * ( latitude - 51.3814282 ) , 2 ) + POW( 69.1 * ( - 2.3574537 - longitude ) * COS( latitude / 57.3 ) , 2 ) ) ) AS distance");
sql.append(" FROM  `address`");
sql.append(" WHERE ( SQRT( POW( 69.1 * ( latitude - 51.3814282 ) , 2 ) + POW( 69.1 * ( - 2.3574537 - longitude ) * COS( latitude / 57.3 ) , 2 ) ) ) < 10.0");
sql.append(" ORDER BY distance DESC");  
sql.append(" LIMIT 0 , 30");

SQLQuery query = session.createSQLQuery(sql.toString());
// call query.addScalar(..) for other fields you select
query.addScalar("distance", Hibernate.BIG_DECIMAL)

//Where AddressBean is the object that maps to a row of this resultset
query.setResultTransformer(Transformers.aliasToBean(AddressBean.class));

 List<AddressBean> list = new ArrayList<AddressBean>(100);
for (Object object : query.list()) {
    list.add((AddressBean)object);
}