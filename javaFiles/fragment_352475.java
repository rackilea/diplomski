@Transactional
void taskA(){
    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("callStoreProcedure1"); 

    if(query.execute()) 
        query.getSingleResult();        

}

@Transactional
void taskB(){
    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("callStoreProcedure2"); 

    if(query.execute())
        query.getSingleResult();                    
}