public class EventBusHolder {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.eventBus().registerDefaultCodec(Holder.class, new HolderCodec());
        vertx.deployVerticle(new SomeVerticle(), (r) -> {
            vertx.eventBus().send("custom", new Holder(new CustomObject("a")));
        });
    }
}

class HolderCodec implements MessageCodec<Holder, Holder> {

    @Override
    public void encodeToWire(Buffer buffer, Holder holder) {

    }

    @Override
    public Holder decodeFromWire(int pos, Buffer buffer) {
        return null;
    }

    @Override
    public Holder transform(Holder holder) {
        return holder;
    }

    @Override
    public String name() {
        return "HolderCodec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}

class SomeVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.eventBus().consumer("custom", (msg) -> {
           System.out.println(msg.body());
        });
    }
}

class CustomObject {
    public String name;

    public CustomObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "name='" + name + '\'' +
                '}';
    }
}


final class Holder {
    @Override
    public String toString() {
        return "Holder{" +
                "data=" + data +
                '}';
    }

    private final List<CustomObject> data;

    public Holder(final CustomObject... data) {
        this.data = Arrays.asList(data);
    }

    public List<CustomObject> getData() {
        return data;
    }
}