-keep public class com.test.blah.config.OnboardingProperties {
  private <fields>;
  *** get*();
}
-keep class com.test.blah.config.OnboardingProperties$* {
  private <fields>;
  void set*(***);
  *** get*();
}