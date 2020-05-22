public class PropertiesAwareBean {

  @Value("${PATH_ERROR}")
  private String errorPath;

  String getErrorPath() {
    return errorPath;
  }

}