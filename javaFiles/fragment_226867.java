jar {
    manifest {
        attributes 'Main-Class': 'co.myapp.sensorPreprocessor.MqttPollerKt'
    }

    exclude 'META-INF/*.RSA', 'META-INF/*.SF','META-INF/*.DSA'

    from {
        (configurations.compile).collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
}