public interface DtoMapper<T> {

    /**
    * Converts list of T into FooResponse
    * @param List of T
    * @return FooResponse
    */
    FooResponse convertToFooResponse(final List<T> rewards);
}

public class FooMapperImplementation implements DtoMapper<Bar> {
    @Override
    public FooResponse convertToFooResponse(List<Bar> rewards) {
        return null;
    }
}