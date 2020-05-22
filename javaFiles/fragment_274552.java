@Component
@ConfigurationProperties(prefix = "thing")
public class ThingProperties {

 private Map<String, ThingLayout> layouts = new HashMap<>();

 public Map<String, ThingLayout> getLayouts() {
     return layouts;
 }

 public void setLayouts(final Map<String, ThingLayout> layouts) {
     this.layouts = new HashMap(layouts);
 }
}