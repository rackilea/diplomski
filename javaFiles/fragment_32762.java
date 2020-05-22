public class ScenarioObject{
private String character;
@XStreamConverter(HolidayTransformer.class)
private Holiday holiday;
(...getters and setters)
}