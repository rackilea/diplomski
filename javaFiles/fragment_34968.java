public class PersistenceContext { // needs to extend if using @Override
    @Override // needs to be @Bean if not extending
    public SessionFactory getSessionFactory() {
        return new SessionFactory("org.neo4j.cineasts.domain");
    }
}