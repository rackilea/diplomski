public static final int CPU = Runtime.getRuntime().availableProcessors()*2;
public static final int BATCH_NODES = 100_000;
public static final int BATCH_RELATIONS = 50_000;


ExecutorService pool = createPool(CPU, CPU * 25);

for(int i = 0; i < things.size(); i = i + BATCH_NODES) {
    CreateNodeAndRelationRunner nodeRunner;
    if(i + BATCH_NODES < things.size()) {
        nodeRunner = new CreateNodeRunner(graphDb, things.subList(i, i + BATCH_NODES));
    } else {
        nodeRunner = new CreateNodeRunner(graphDb, things.subList(i, things.size()));
    }

    pool.submit(nodeRunner);
}
pool.shutdown();

boolean nodesCreated = false;
try {
        nodesCreated = pool.awaitTermination(1, TimeUnit.DAYS);
} catch (InterruptedException e) {
        logger.debug("CreateNodeThread was interrupted");
        logger.debug(e.getMessage());
}

if(nodesCreated) {

        pool = createPool(CPU, CPU * 25);

        for(int i = 0; i < things.size(); i=i+ BATCH_RELATIONS) {
            CreateRelationsRunner relationsRunner;
            if(i+ BATCH_RELATIONS < things.size()) {
                relationsRunner = new CreateRelationsRunner(graphDb, things.subList(i, i+ BATCH_RELATIONS));
            } else {
                relationsRunner = new CreateRelationsRunner(graphDb, things.subList(i, things.size()));
            }

            pool.submit(relationsRunner);
        }
        pool.shutdown();
}