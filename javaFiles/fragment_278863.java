synchronized (obj) {
        try {
            obj.wait(someTime);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }