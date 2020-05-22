executor.submit(new Runnable() {
                public void run() {
                    for (int i = 0; i < NUM_OF_INV; i++) {
                        try {
                            bc.somethingElse();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });