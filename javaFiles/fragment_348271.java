public interface IEntityParam {
    public void validateParam(Object object);
}

public interface IEntityParamExtended extends IEntityParam {
    public default void validateParam(Object object,List<String> Str);
}