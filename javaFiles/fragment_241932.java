public class AppInjector extends AbstractModule {


        @Override
        protected void configure() {


            /*
             * JPA Bindings
             */
            bind(JPASearchProcessor.class).toProvider(JPASearchProcessorProvider.class);
            bind(MetadataUtil.class).toProvider(HibernateMetadataUtilProvider.class);


    }