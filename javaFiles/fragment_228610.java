@Component
@Getter // Lombok annotation to generate getter methods
@Setter // Lombok annotation to generate setter methods
public class StrategySearchSpecification
{
  private CODE_TYPE code;
  private String name;
  private TYPE_TYPE type;
}