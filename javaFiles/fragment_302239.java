public class ScheduledExecution {

    public void createEnemyByPattern() {

        EnemyActivator factory = new EnemyActivator(5, 500);

        new Thread(factory).start();

    }

}

class EnemyActivator implements Runnable {

    private final int enemyCount;
    private final long creationDelay;

    EnemyActivator(int enemyCount, long creationDelay) {
        this.enemyCount = enemyCount;
        this.creationDelay = creationDelay;
    }

    @Override
    public void run() {

        for(int i=0; i<enemyCount; ++i) {
            activateEnemy();
            try {
                TimeUnit.MILLISECONDS.sleep(creationDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void activateEnemy() {
        // create and send enemy code here
    }


}