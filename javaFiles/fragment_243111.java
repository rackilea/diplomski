val assets by configurations.creating

dependencies {
    assets("somegroup", "someArtifact", "someVersion")
}

tasks {
    val extractApi by creating(Sync::class) {
        dependsOn(assets)

        from(assets.map {
            zipTree(it)
        })

        into("$buildDir/api/")
    }
}