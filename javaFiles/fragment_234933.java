interface Bean<T> {
    T convertToDto();
}
public abstract class BaseService {
    public <T,R extends Bean<T>> List<T> convertsToDto(List<R> beans) {
        return beans.stream().map((b) -> b.convertToDto()).collect(Collectors.toList());
    }
    ... // Additional methods
}