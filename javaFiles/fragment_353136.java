public class DaoCacheKeyGenerator implements CacheKeyGenerator<DaoCacheKey> {

    @SuppressWarnings("unchecked")
    @Override
    public DaoCacheKey generateKey(MethodInvocation methodInvocation) {
        Method method = methodInvocation.getMethod();
        Class<? extends GenericDao<?, ?>> daoType = (Class<? extends GenericDao<?, ?>>) methodInvocation.getThis().getClass().getInterfaces()[0];
        Class<? extends Persistable<?>> domainType = getDomainType(daoType);
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] parameters = methodInvocation.getArguments();
        return new DaoCacheKey(domainType, methodName, parameterTypes, parameters);
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Persistable<?>> getDomainType(Class<?> daoType) {
        Type baseDaoType = GenericTypeReflector.getExactSuperType(daoType, GenericDao.class);
        ParameterizedType parameterizedBaseDaoType = (ParameterizedType) baseDaoType;
        return (Class<? extends Persistable<?>>) parameterizedBaseDaoType.getActualTypeArguments()[0];
    }

    @Override
    public DaoCacheKey generateKey(Object... data) {
        return null;
    }

}