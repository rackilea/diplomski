@Transactional
public void createB(informations){

    A a = informations.getA()
    session.get(A.class, a.getId(), LockMode.READ) //BD Lock here, no cluster, no Java

    //Only who got the lock first get here, anyone else waits for the lock release

    Long lastSequential = bService.findLastSequential()
    B newB = informations.getB()
    newB.setSequential(lastSequential + 1)
    session.persist(newB)

    //The lock is released when the transaction finishes and then the next
    //thread awaiting on the session.get may get a new lock and resume its 
    //execution. That way only one thread at time will be able to execute
    //the critical area where the sequential is being created.
}