public class DaoCacheKey implements Serializable {

    private static final long serialVersionUID = 338466521373614710L;

    private Class<? extends Persistable<?>> domainType;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    public DaoCacheKey(Class<? extends Persistable<?>> domainType, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
        this.domainType = domainType;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public Class<? extends Persistable<?>> getDomainType() {
        return domainType;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof DaoCacheKey && hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { domainType, methodName, Arrays.asList(parameterTypes), Arrays.asList(parameters) });
    }

}