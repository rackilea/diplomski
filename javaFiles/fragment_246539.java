android {
  defaultConfig {
   ...
   testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

   // The following argument makes the Android Test Orchestrator run its
   // "pm clear" command after each test invocation. This command ensures
   // that the app's state is completely cleared between tests.
   testInstrumentationRunnerArguments clearPackageData: 'true'
 }

  testOptions {
    execution 'ANDROIDX_TEST_ORCHESTRATOR'
  }
}

dependencies {
  androidTestImplementation 'androidx.test:runner:1.1.0'
  androidTestUtil 'androidx.test:orchestrator:1.1.0'
}