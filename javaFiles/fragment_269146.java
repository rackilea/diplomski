String queryText = "select address.*, photo.* from ADDRESS address 
                    left join PHOTO photo on (address.person_id=photo.person_id)";

List<Object[]> rows = sess.createSQLQuery(queryText)
                          .addEntity("address", Address.class)
                          .addEntity("photo", Photo.class)
                          .list();