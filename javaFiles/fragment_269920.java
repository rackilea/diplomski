import com.github.jengelman.gradle.plugins.shadow.transformers.ServiceFileTransformer
shadowJar {
    // Make sure the cxf service files are handled correctly so that the SOAP services work.
    // Ref https://stackoverflow.com/questions/45005287/serviceconstructionexception-when-creating-a-cxf-web-service-client-scalajava
    transform(ServiceFileTransformer) {
        path = 'META-INF/cxf'
        include 'bus-extensions.txt'
    }
}