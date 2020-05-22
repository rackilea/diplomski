// create session
try {    
    tx = session.beginTransaction();
    // do something
    tx.commit();
} catch (Exception exp) {
    tx.rollback();

}

try {    
    tx = session.beginTransaction();
    // do something
    tx.commit();
} catch (Exception exp) {
    tx.rollback();

}
// close session