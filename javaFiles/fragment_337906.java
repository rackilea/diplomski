MyObject objectFromPool = null;
    try {
        try {
                objectFromPool = pool.borrowObject(); // step (1), throws plain Exception   
            } catch (Exception e) {
                // Encapsulate into an specific exception type:
                throw new MyOwnException(e);
            }
            objectFromPool.doSomething();         // step (2), throws FailedToDoSomethingException
        } catch (FailedToDoSomethingException e) {
            throw new MyCustomRuntimeException(e);    
        } catch (MyOwnException e) {
            ...
        } finally {
            if (objectFromPool != null) {
                pool.returnObject(objectFromPool); // step (3)
            }
        }