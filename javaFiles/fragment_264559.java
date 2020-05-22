// start a transaction
transaction = session.beginTransaction();

// add the user object
session.save(obj);

// commit transaction
transaction.commit();

//closing session
session.close();