sourceSets {
    api{
    }
}

dependencies {
    //depend on the source set
    compile sourceSets.api.output
}

jar{
    //include output of API source set
    from  sourceSets.api.output
}