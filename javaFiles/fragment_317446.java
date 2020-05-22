public class EntryDAOModule extends AbstractModule {

    @Override
    protected void configure() {
        //bind(EntryDAO.class).to(EntryDAOMongoImpl.class); // what should this be?

        FactoryModuleBuilder factoryModuleBuilder = new FactoryModuleBuilder();
        install(factoryModuleBuilder.build(EntryDAOFactory.class));
    }
}