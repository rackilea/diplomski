void transactional(Runnable r) {
        hbu.createSession();
        try {
            hbu.beginTransaction();
            try {
                r.run();
                hbu.commitTransaction();
            } catch (Exception e) {
                hbu.rollbackTransaction();
                // perhaps re-throw exception here
            }
        } finally {
            hbu.closeSession();
        }
    }

    void doSmthg(){
    }

    void doSmthgElse(){
        doSmthg();
    }

    void useTransactional(){
        transactional(() -> {
            doSmthg();
            doSmthgElse()
        });

        transactional(() -> doSmthg());
    }