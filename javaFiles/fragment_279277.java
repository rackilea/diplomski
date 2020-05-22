android {
    ...
    defaultConfig {
       ...
        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath true
            }
        }

    }
}