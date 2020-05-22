int i = 0;
for(Deal deal : deals)
    session.save(deal);
    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
        //flush a batch of inserts and release memory:
        session.flush();
        session.clear();
    }
   i++; 
}
session.flush();
session.clear();