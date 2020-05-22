public class PriceSerializer extends BaseGsonSerializer {

    protected Type getTypeDeserialize() {
        return new TypeToken<Price>() {
        }.getType();
    }
}

public class PriceListSerializer extends BaseGsonSerializer {

    protected Type getTypeDeserialize() {
        return new TypeToken<List<Price>>() {
        }.getType();
    }
}