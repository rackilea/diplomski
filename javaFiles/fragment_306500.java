task('addVersion') {
    doLast {
       //append the version here, see example
       file("src/main/resources/props.properties").append("version=$version")
    }
}
jar.dependsOn(addVersion)