import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import javax.persistence.Query;

Coordinate coord = new Coordinate(52.5, 13.3);
Point point = new GeometryFactory().createPoint(coord);
Query query = em.createQuery("FROM Cities WHERE WITHIN(:location, polygon) = true", Cities.class);
query.setParameter("location", point);