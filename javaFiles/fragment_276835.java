processResources {
    filesMatching('**/app.properties') {
        filter {
            it.replace('%APP_VERSION_TOKEN%', version)
        }
    }
}