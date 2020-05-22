@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        super(MultiPartFeature.class);
        register(MoxyXmlFeature.class);
        packages("info.toegepaste.www.ejb"); 
        packages("info.toegepaste.www.entity");
    }
}