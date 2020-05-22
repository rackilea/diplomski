public class Subclass<T> extends TypeReference<AgentResponse<T>>{
    public Subclass() {
        System.out.println(getClass().getGenericSuperclass());
        System.out.println(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}