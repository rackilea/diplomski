@Entity class
import com.vividsolutions.jts.geom.Geometry;

@JsonSerialize(using = GeometryToJsonSerializer.class)
@JsonDeserialize(using = JsonToGeometryDeserializer.class)
@Column(name = "request_point", columnDefinition = "Geometry")
private Geometry request_point;


// JsonDeserializer method 
public class JsonToGeometryDeserializer extends JsonDeserializer<Geometry> {
@Override
public Geometry deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

    try {
        String text = jp.getText();
        if (text == null || text.length() <= 0)
            return null;

        MapGeometry geo = GeometryEngine.jsonToGeometry(text);
        String geomWkt = GeometryEngine.geometryToWkt(geo.getGeometry(), 0);

          WKTReader wktR = new WKTReader();
          Geometry geom = wktR.read(geomWkt);
          geom.setSRID(geo.getSpatialReference().getID());
        return geom;

    } catch (Exception e) {
        return null;

    }
}