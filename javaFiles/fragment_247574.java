import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.PostConstructAdapterFactory;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import javax.annotation.PostConstruct;

public class GsonApp {

    public static void main(String[] args) {
        RuntimeTypeAdapterFactory<BaseClass> typeFactory = RuntimeTypeAdapterFactory.of(BaseClass.class)
                .registerSubtype(DerivedClass.class);

        Gson serializer = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();

        Gson deserializer = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .registerTypeAdapterFactory(new PostConstructAdapterFactory())
                .create();

        WrapperClass wrapper = new WrapperClass();
        wrapper.setDc(new DerivedClass(8));

        String json = serializer.toJson(wrapper);
        System.out.println(json);
        System.out.println(deserializer.fromJson(json, WrapperClass.class));
    }

}

class WrapperClass {
    protected BaseClass dc;

    public BaseClass getDc() {
        return dc;
    }

    public void setDc(BaseClass dc) {
        this.dc = dc;
    }

    @Override
    public String toString() {
        return "WrapperClass{" +
                "dc=" + dc +
                '}';
    }
}

class BaseClass {

    @PostConstruct
    protected void postConstruct() {
    }
}

class DerivedClass extends BaseClass {
    public DerivedClass(Integer number) {
        super();
        this.number = number;
        Init();
    }

    protected Integer number;
    protected transient Integer doubled;
    protected transient Integer tripled;
    protected transient Integer halved;
    protected transient Integer squared;
    protected transient Integer cubed;

    public void Init() {
        halved = number / 2;
        doubled = number * 2;
        tripled = number * 3;
        squared = number * number;
        cubed = number * number * number;
    }

    @PostConstruct
    protected void postConstruct() {
        Init();
    }

    @Override
    public String toString() {
        return "DerivedClass{" +
                "number=" + number +
                ", doubled=" + doubled +
                ", tripled=" + tripled +
                ", halved=" + halved +
                ", squared=" + squared +
                ", cubed=" + cubed +
                "} ";
    }
}