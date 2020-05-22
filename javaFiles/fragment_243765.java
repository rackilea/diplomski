configurations.all {
 resolutionStrategy.eachDependency {  details ->
    def requested = details.requested
    if (requested.group == 'com.android.support') {
        if (!requested.name.startsWith("multidex")) {
            details.useVersion "28.0.0"
        }
    }
  }
}