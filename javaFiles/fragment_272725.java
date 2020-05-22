public class CustomGenerator extends IdentityGenerator implements Configurable {

    private IdentifierGenerator defaultGenerator;

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Long idValue = (Long)defaultGenerator.generate(session, object);
        //idValue will be assigned your entity id
        return idValue;
    }

    @Override
    public void configure(Type type, Properties params, Dialect d) throws MappingException {
        DefaultIdentifierGeneratorFactory dd = new DefaultIdentifierGeneratorFactory();
        dd.setDialect(d);
        defaultGenerator = dd.createIdentifierGenerator("sequence", type, params);
    }
}