public class MyDialect extends AbstractDialect implements IExpressionEnhancingDialect {

  public MyDialect() {
    super();
  }

  @Override
  public String getPrefix() {
    // @see org.thymeleaf.dialect.IDialect#getPrefix
    return "xxx";
  }

  @Override
  public boolean isLenient() {
    return false;
  }

  @Override
  public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext ctx) {
    Map<String, Object> expressions = new HashMap<>();
    expressions.put("labels", new LabelUtil());
    return expressions;
  }
}