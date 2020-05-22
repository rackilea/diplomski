public class SimulationContext {

    private Session session = null;
    private Transaction transaction = null;

    private List<Simulateable> simulatedObjects;

    public SimulationContext() {
        this.simulatedObjects = new ArrayList<Simulateable>();
    }

    /** ... add, remove, clear, ... */

    /**
     * Start simulation: Start transaction and persist simulation entities.
     * @param session
     */
    public void start(Session session) {
        if (this.session != null) {
            this.stop();
        }
        this.session = session;
        this.transaction = session.beginTransaction();

        // Initializing simlation context, persisting simulated objects
        for (Simulateable object : simulatedObjects) {
            // persist object ...
            session.persist(object);
            session.flush();
            // ... and remove it from session cache (otherwise lazy loaded objects referenced by foreign keys might not get loaded)
            session.evict(object);
        }
    }

    /**
     * Stop simulation: Roll-back the transaction and close the session.
     */
    public void stop() {
        transaction.rollback();
        transaction = null;
        session = null;
    }
}