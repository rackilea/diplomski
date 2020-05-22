Set<ResultAux> resultAuxes = result.getResultAuxes();
ResultAux  newResultAux = new ResultAux();

/**
 * As session.save()  requires to return the ID for the saved instance , if  "sequence" strategy is 
 * used , Hibernate will hit the DB  to select the next ID (eg. select some_seq.NEXTVAL) to be used 
 * for the saved instance. So newResultAux  will have an ID after save()  but actually it is not saved to 
 * the DB yet as  saving to the DB  occurs during session.flush()
 */
session.save(newResultAux);
resultAuxes.add(newResultAux);