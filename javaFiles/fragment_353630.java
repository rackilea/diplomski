@ObjectCreate(pattern = "*/Criteria/Criterion")
public static class CriterionNode {

  @BeanPropertySetter(pattern = "*/Criteria/Criterion/Name")
  private String name;
  @BeanPropertySetter(pattern = "*/Criteria/Criterion/Description")
  private String description;