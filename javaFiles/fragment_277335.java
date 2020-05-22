@NoRepositoryBean
public interface EnumerationRepository<T extends IDatabaseEnumeration> extends Repository<T, String> {

    // ...

    default Class<T> getEntityClass() {
        Type[] interfaces = getClass().getInterfaces();

        for (Type t : interfaces) {
            if (t instanceof Class<?>) {
                Class<?> clazz = (Class<?>) t;

                if (clazz.getPackage().getName().startsWith(ApplicationConst.BASE_PACKAGE)) {

                    // Repositories should implement only ONE interface from application packages

                    Type genericInterface = clazz.getGenericInterfaces()[0];

                    return (Class<T>) ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
                }
            }
        }

        return null;
    }

}