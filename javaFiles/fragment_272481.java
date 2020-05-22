/**
 * Adds a public static String field to BuildConfig containing
 * the Retrofit version, no matter what build type is used.
 */
task createRetrofitBuildConfigField << {
    project.configurations.compile.each {
        if (it.name.contains("retrofit")) {
            android.buildTypes.each { flavor ->
                def version = it.name.replaceFirst(~/\.[^\.]+$/, "") // Removes extension.
                flavor.buildConfigField("String", "RETROFIT_VERSION", "\"${version}\"")
            }
        }
    }
}

preBuild.dependsOn createRetrofitBuildConfigField