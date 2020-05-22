@Getter @Setter
public class ObjectToMapTo {
    private String name;
    @JsonDeserialize(using =  MyDeserializer.class)
    private Object value;
}