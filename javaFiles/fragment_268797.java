@JsonSerialize(using = CustomSerializer.class)
public class JsonResponse {
    private boolean success;
    private Result<?> result;

    //general getters ans setters
}