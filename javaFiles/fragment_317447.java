public class EntryDAOModule extends AbstractModule {

    @Override
    protected void configure() {
        EtnryDTOMongoImpl dto = new EntryDTOMongoImpl(TargetEntry.class); //guessing here
        bind(EntryDAO.class).toInstance(new EntryDAOMongoImpl(dto)); // singleton   
    }
}