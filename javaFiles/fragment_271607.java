@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties
{
   @Min(4)
   private int value;

   @Max(6)
   private int value2;

   @Valid
   private SubProperties sub;

   ... getters and setters ...
}