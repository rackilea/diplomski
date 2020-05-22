@Named
public class EmailUtils {

  @Value("${from:me@me.com}")
  private String from;

  @Value("${to:you@you.com}")
  private String to;
  ...
}