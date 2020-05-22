package core.models.dao;

    import com.google.inject.Inject;
    import com.google.inject.Provider;
    import com.googlecode.genericdao.search.MetadataUtil;
    import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

    public class JPASearchProcessorProvider implements Provider<JPASearchProcessor> {

        @Inject
        private MetadataUtil mdu;

        @Override
        public JPASearchProcessor get() {
            return new JPASearchProcessor(mdu);
        }

    }