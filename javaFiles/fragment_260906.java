public class MySpringTemplateEngine extends SpringTemplateEngine {

   private Set<IProcessor> additionalProcessors;

   public Set<IProcessor> getAdditionalProcessors() {
      return additionalProcessors;
   }

   public void setAdditionalProcessors(Set<IProcessor> additionalProcessors) {
      this.additionalProcessors = additionalProcessors;
   }

   @Override
   public void afterPropertiesSet() throws Exception {
      super.afterPropertiesSet();
      Map<String, IDialect> dialectsByPrefix = this.getDialectsByPrefix();
      StandardDialect springDialect = (StandardDialect) dialectsByPrefix.get("th");
      springDialect.setAdditionalProcessors(additionalProcessors);
   }
}