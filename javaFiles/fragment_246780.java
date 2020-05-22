import com.github.jengelman.gradle.plugins.shadow.transformers.ServiceFileTransformer
shadowJar {
    transform(ServiceFileTransformer) {
        path = 'META-INF/services'
        include 'org.eclipse.jetty.http.HttpFieldPreEncoder'
    }
}