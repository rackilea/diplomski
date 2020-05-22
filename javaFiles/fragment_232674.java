public class YourRulesDefinition implements RulesDefinition {
  private final Settings settings;

  public YourRulesDefinition(Settings s) {
    this.settings = s;
  }

  void yourMethod() {
    if(settings.hasKey("sonar.root.path")) {
      // ...
    }
  }
}