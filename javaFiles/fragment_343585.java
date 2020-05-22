public void Object1Insert(final Object1 object1) {
    genericSQLRetry(new Runnable {
        public void run() {
            insertObject1(object1);
        }
    });
}

public void Object2Insert(Object2 object2) {
    genericSQLRetry(new Runnable {
        public void run() {
            insertObject2(object2);
        }
    });
}

public void genericSQLRetry(Runnable retryable) {
    int retries = 5;
    boolean isException = false;
    do {
        try {
            isException = false;
            retries--;
            //Invoke method
            retryable.run();
        }
        catch (SQLException e) {
            isException = true;
        }

        if (isException & retries > 0) {
            //getRandomSleep would be between 750-1250ms. This is to stop multiple retries at the same time.
            Thread.sleep(getRandomSleep());
        }
    } while (isException == true && retries > 0);
}