DateFormat df;    
df= new SimpleDateFormat("y: m: d");
String dt= sdf.format(date);    
Query query = session.createSQLQuery
("Select  id,fecha,total,idEnvio FROM VENTA_CABECERA vc WHERE fecha = :fec" )
.addEntity(HeadSale.class);
query.setParameter("fec", dt);
return query.list();