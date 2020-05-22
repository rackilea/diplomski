public class JsonMocksRepository<T>{
  private final TypeReference<T> typeRef;

  public JsonMocksRepository(TypeReference<T> typeRef) {
    this.typeRef = typeRef;
  }

  public T getObject() throws Exception{
    return mapper.readValue(file, typeRef);
  }
}