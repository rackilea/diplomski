public class Main {
    public static void main(String[] args) throws Exception {
        JetInstance jet = Jet.newJetInstance();
        try {
            HazelcastInstance hz = jet.getHazelcastInstance();
            ILogger logger = hz.getLoggingService().getLogger("a");

            // every second via executorservice:
            final IStreamMap<Long, List<byte[]>> data = jet.getMap("data");
            List<byte[]> myByteArray = asList(new byte[1], new byte[2]);
            IAtomicLong keyGen = hz.getAtomicLong("key");
            Long key = keyGen.getAndIncrement();
            data.set(key, myByteArray);

            String stringKey = key.toString();
            hz.getList(stringKey).addAll((List<byte[]>) jet.getMap("data").get(key));
            jet.getMap("data").remove(key);
            logger.severe(String.format("List %s has size: %d", key, jet.getList(stringKey).size()));

            hz.getMap("result").addEntryListener((EntryAddedListener<Long, byte[]>)
                    (EntryEvent<Long, byte[]> entryEvent) -> logger.severe(String.format(
                            "Got result: %d at %d", entryEvent.getValue().length, System.currentTimeMillis())),
                    true);

            DAG dag = new DAG();
            Vertex sourceDataMap = dag.newVertex("sourceDataMap", readList(stringKey)).localParallelism(1);
            Vertex parseByteArrayToMap = dag.newVertex("parseByteArrayToMap", map(
                    (byte[] e) -> entry(randomUUID(), e)));
            Vertex sinkIntoResultMap = dag.newVertex("sinkIntoResultMap", writeMap("result"));

            dag.edge(between(sourceDataMap, parseByteArrayToMap))
               .edge(between(parseByteArrayToMap, sinkIntoResultMap));

            jet.newJob(dag).execute().get();
            Thread.sleep(1000);
        } finally {
            Jet.shutdownAll();
        }
    }
}