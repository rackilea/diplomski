String queryText = "select address, photo from Address address, Photo photo " 
                 + " where address.personID=photo.personId";
List<Object[]> rows = session.createQuery(queryText).list();

for (Object[] row: rows) {
    System.out.println(" ------- ");
    System.out.println("Address object: " + row[0]);
    System.out.println("Photo object: " + row[1]);
}