public class BatchExecutor {

    public static enum ResultNotification {
        JMS,
        MAIL
    };

    public Runnable createRunnable(ResultNotification type) {
        abstract class Prototype implements Runnable {
            public void run() {
                performBusinessLogic();
                publishResult();
            }

            abstract void publishResult();
        }

        switch (type) {
            case JMS: {
                return new Prototype() {
                    void publishResult() {
                        //Post result to JMS
                    }
                };
            }
            case MAIL: {
                return new Prototype() {
                    void publishResult() {
                        //Post result to MAIL
                    }
                };
            }
        }
        return null;
    }

    private void performBusinessLogic() {
        //Some business logic
    }

}