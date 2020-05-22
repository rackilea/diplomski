public class DomainProvider {
    // Just inject Providers directly without binding them explicitly.
    @Inject @Earth Provider<IDao> earthDaoProvider;
    @Inject @Mars Provider<IDao> marsDaoProvider;

    public Provider<IDao> get(Domain domain){
        switch (domain){
            case EARTH:
                return earthDaoProvider;
            case MARS:
                return marsDaoProvider;
        }
    }

    public Provider<IDao> get(String domain){
        Domain parsedDomain = Domain.valueOf(domain.toUpperCase());
        return get(parsedDomain);
    }
}