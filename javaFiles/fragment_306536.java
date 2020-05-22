task copyLocalizations(type: Copy) {
    from('src/main/resources')
    into(sourceSets.main.output.resourcesDir)
    include('localization.properties')
    rename('localization.properties', 'localization_en.properties')
}

processResources.dependsOn(copyLocalizations)