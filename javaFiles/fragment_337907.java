try {
                objectFromPool = pool.borrowObject(); // step (1), throws plain Exception   
            } catch (RuntimeException e) {
                // Let it propagate:
                throw e;
            } catch (Exception e) {
                // Encapsulate into an specific exception type:
                throw new MyOwnException(e);
            }