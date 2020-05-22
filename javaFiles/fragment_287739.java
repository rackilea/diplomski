@Entity
@Audited
@Table(name = "geo_element")
@ForeignKey(name = "FK_geo_element__id__element")
@TypeDef(name = "geometry", typeClass = GeometryType.class)
public class GeoElement extends Element {

  @Type(type = "geometry")
  @Column(name = "data")
  private Point data;

  //...
}