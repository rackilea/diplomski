configure(project.rootProject) {
    ext {
        additionalBuildInfo = { subproject ->
        return [
                operatingSystem: "${System.properties['os.name']} (${System.properties['os.version']})",
                continuousIntegration: System.getenv('CI') ? true: false,
                machine: InetAddress.localHost.hostName,
                // Override buildInfo property time
                time: new Date(System.currentTimeMillis()).format('EEE MMM dd HH:mm:ss z yyyy')
        ]
    }
}