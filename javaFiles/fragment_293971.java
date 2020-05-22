public interface MySerializer
{
    boolean serialize(MyDomainObject input);
}

public PBBasedSerializer implements MySerializer
{
    private final MyMessageBuilder protoBuilder;
    ...
}

public JsonBasedSerializer implements MySerializer
{
    private final JSONSerializer jsonSerializer;
    ...
}