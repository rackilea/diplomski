public class GeoModuleExt extends SimpleModule {

    public GeoModuleExt() {
        super("Mixins", new Version(1, 0, 0, null));
        setMixInAnnotation(GeoResult.class, GeoResultMixin.class);
        setMixInAnnotation(GeoResults.class, GeoResultsMixin.class);
    }

    static abstract class GeoResultMixin {
        GeoResultMixin(@JsonProperty("content") Object content, 
                       @JsonProperty("distance") Distance distance) {    
        }
    }

    static abstract class GeoResultsMixin {
        GeoResultsMixin(@JsonProperty("results")List<GeoResult> results) {

        }   
    }
}