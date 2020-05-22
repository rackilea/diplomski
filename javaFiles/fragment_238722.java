import org.apache.commons.lang3.ArrayUtils;
import com.google.gson.Gson;

public class Scratch {
    public static void main(String[] args) throws Exception {
        String json = "{" + 
                "   \"geometry\": {" + 
                "       \"type\": \"Polygon\"," + 
                "       \"coordinates\": [" + 
                "           [" + 
                "               [-69.899139," + 
                "                   12.452005" + 
                "               ]," + 
                "               [-69.895676," + 
                "                   12.423015" + 
                "               ]" + 
                "           ]" + 
                "       ]" + 
                "   }" + 
                "}";

        Geometry g = new Gson().fromJson(json, Geometry.class);
        System.out.println(g);
        // Geometry [geometry=GeometryData [type=Polygon, coordinates={{{-69.899139,12.452005},{-69.895676,12.423015}}}]]
    }
}
class Geometry {
    GeometryData geometry;

    @Override
    public String toString() {
        return "Geometry [geometry=" + geometry + "]";
    }
}
class GeometryData {
    String type;
    double[][][] coordinates;

    @Override
    public String toString() {
        return "GeometryData [type=" + type + ", coordinates=" + ArrayUtils.toString(coordinates) + "]";
    }
}