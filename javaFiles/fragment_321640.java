public class StringSequenceIdentifier implements IdentifierGenerator, Configurable {

    private String sequenceCallSyntax;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        final JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);
        final Dialect dialect = jdbcEnvironment.getDialect();

        final String sequencePerEntitySuffix = ConfigurationHelper.getString(CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, params, DEF_SEQUENCE_SUFFIX);

        final String defaultSequenceName = ConfigurationHelper.getBoolean(CONFIG_PREFER_SEQUENCE_PER_ENTITY, params, false)
                ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
                : DEF_SEQUENCE_NAME;

        sequenceCallSyntax = dialect.getSequenceNextValString(ConfigurationHelper.getString(SEQUENCE_PARAM, params, defaultSequenceName));
    }

    @Override
    public Serializable generate(SessionImplementor session, Object obj) {
        if (obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            if (id != null) {
                return id;
            }
        }
        long seqValue = ((Number) Session.class.cast(session)
            .createSQLQuery(sequenceCallSyntax)
            .uniqueResult()).longValue();

        return "CTC" + seqValue;
    }
}