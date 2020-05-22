String serverURL = grailsApplication.config.grails.serverURL
URL url = new URL(serverURL)
System.setProperty("java.rmi.server.hostname", "${url.host}")
rmiRegistry(org.springframework.remoting.rmi.RmiRegistryFactoryBean) {
    port = 9999
    alwaysCreate: true
}


serverConnector(org.springframework.jmx.support.ConnectorServerFactoryBean) { bean ->
    bean.dependsOn = ['rmiRegistry']
    objectName = "connector:name=rmi"
    serviceUrl = "service:jmx:rmi://${url.host}/jndi/rmi://${url.host}:9999/jmxrmi"
    environment = ['java.rmi.server.hostname'                 : "${url.host}",
                   'jmx.remote.x.password.file'               : "${grailsApplication.parentContext.getResource('/WEB-INF/jmx/jmxremote.password').file.absolutePath}",
                   'jmx.remote.x.access.file'                 : "${grailsApplication.parentContext.getResource('/WEB-INF/jmx/jmxremote.access').file.absolutePath}",
                   'com.sun.management.jmxremote.authenticate': true,
                   'com.sun.management.jmxremote.local.only'  : false,
                   'com.sun.management.jmxremote'             : true]
}