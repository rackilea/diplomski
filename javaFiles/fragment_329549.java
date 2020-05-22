flavorDimensions "default"   
 productFlavors {
    dev {
buildConfigField "String", "SERVER_TEST", "\"http://192.618..\""
buildConfigField "String", "SERVER_MAIN", "\"https://68.5...\""
buildConfigField "String", "API_KEY", "dev API key"
    }
     prod {
buildConfigField "String", "SERVER_TEST", "\"http://192.618..\""
buildConfigField "String", "SERVER_MAIN", "\"https://68.5...\""
buildConfigField "String", "API_KEY", "prod API key"
    }