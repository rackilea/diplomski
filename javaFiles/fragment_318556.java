public class CustomRedshiftDialect extends PostgreSQL81Dialect {

    @Override
    public String getQuerySequencesString() {
        return null;
    }
}