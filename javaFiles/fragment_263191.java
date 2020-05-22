configurations.all {
    resolutionStrategy.eachDependency { details ->
        if (details.requested.group == 'com.android.support') {
            details.useVersion "28.0.0"
        }
    }
}