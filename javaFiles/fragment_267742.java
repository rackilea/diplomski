public static LinkedBlockingQueue<Pair<String, String>> mappings;
public static final Pair<String, String> end =
    new Pair<String, String>("END", "END");
public static AtomicBoolean done;
public static NpToEntityMapping mapping;
public static Set<String> attested_nps;
public static Set<Entity> possible_entities;

public static class ProducerThread implements Runnable {
    private File f;

    public ProducerThread(File f) {
        this.f = f;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String entities = reader.readLine();
                String np = line.trim();
                mappings.put(new Pair<String, String>(np, entities));
            }
            reader.close();
            for (int i=0; i<num_threads; i++) {
                mappings.put(end);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer thread interrupted");
        } catch (IOException e) {
            System.out.println("Producer thread threw IOException");
        }
    }
}

public static class WorkerThread implements Runnable {
    private Dictionary dict;
    private EntityFactory factory;

    public WorkerThread(Dictionary dict, EntityFactory factory) {
        this.dict = dict;
        this.factory = factory;
    }

    public void run() {
        try {
            while (!done.get()) {
                Pair<String, String> np_ent = mappings.take();
                if (np_ent == end) {
                    done.set(false);
                    continue;
                }
                String entities = np_ent.getRight();
                String np = np_ent.getLeft().toLowerCase();
                if (attested_nps == null || attested_nps.contains(np)) {
                    int np_index = dict.getIndex(np);
                    HashSet<Entity> entity_set = new HashSet<Entity>();
                    for (String entity : entities.split(", ")) {
                        Entity e = factory.createEntity(entity.trim());
                        if (possible_entities != null) {
                            possible_entities.add(e);
                        }
                        entity_set.add(e);
                    }
                    mapping.put(np_index, entity_set);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Worker thread interrupted");
        }
    }
}