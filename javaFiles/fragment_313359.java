@ConfigurationProperties(prefix = "heroes")
@Getter
@Setter
public class HeroesProperties {

    private Map<String, List<String>> heroesMapping;

}