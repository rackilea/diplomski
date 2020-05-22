javadoc {
    source = sourceSets.main.allJava
    ...
    exclude "com/mobaires/sdk/api/debug/**"

    title = null

    options.doclet = "com.google.doclava.Doclava"
    options.docletpath = [file("libs/doclava-1.0.5.jar")]    
}