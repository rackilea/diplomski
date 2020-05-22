public class EntryDAOMongoImpl extends GenericDAOMongoImpl<EntryDTOMongoImpl, ObjectId> implements EntryDAO<EntryDTOMongoImpl> {
    private static final Logger logger = Logger.getLogger(EntryDAOMongoImpl.class);

    @Inject
    public EntryDAOMongoImpl(@Assisted Class<EntryDTOMongoImpl> entityClass) throws UnknownHostException {
        super(entityClass);
    }
    ...
}