public class DaoCacheEventListener implements CacheEventListener {

    @SuppressWarnings("unchecked")
    @Override
    public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
        DaoCacheKey daoCachekey = (DaoCacheKey) element.getKey();
        List<Class<? extends Persistable<?>>> impacts = getOneToManyImpacts(daoCachekey.getDomainType());
        for (DaoCacheKey daoCachedkey : (List<DaoCacheKey>) cache.getKeys()) {
            if (impacts.contains(daoCachedkey.getDomainType())) {
                cache.remove(daoCachedkey);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private List<Class<? extends Persistable<?>>> getOneToManyImpacts(Class<? extends Persistable<?>> domainType) {
        List<Class<? extends Persistable<?>>> impacts = new ArrayList<Class<? extends Persistable<?>>>();
        impacts.add(domainType);
        for (Method method : domainType.getDeclaredMethods()) {
            if (method.isAnnotationPresent(OneToMany.class)) {
                ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
                Class<? extends Persistable<?>> impactedDomainType = (Class<? extends Persistable<?>>) parameterizedType.getActualTypeArguments()[0];
                if (!impacts.contains(impactedDomainType)) {
                    impacts.addAll(getOneToManyImpacts(impactedDomainType));
                }
            }
        }
        return impacts;
    }

    @Override
    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
    }

    @Override
    public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
    }

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
    }

    @Override
    public void notifyElementEvicted(Ehcache cache, Element element) {
    }

    @Override
    public void notifyRemoveAll(Ehcache cache) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}