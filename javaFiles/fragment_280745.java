public class DetailedDuplicateKeyExceptionTransaltor extends MongoExceptionTranslator {

    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
        if (ex instanceof MongoException.DuplicateKey) {
            return new DetailedDuplicateKeyException(ex.getMessage());
        }
        return super.translateExceptionIfPossible(ex);
    }
}