@Component
@ConfigurationProperties(prefix ="optionA", locations = "classpath:options.yml")
public class OptionA extends Option{
}
@Component
@ConfigurationProperties(prefix ="optionB", locations = "classpath:options.yml")
public class OptionB extends Option{
}