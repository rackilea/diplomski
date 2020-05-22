project(":core") {
    apply plugin: "java"

    dependencies {
        ......
        compile group: 'com.esotericsoftware', name: 'kryo', version: '3.0.3'
    }
}

project(":desktop") {
    apply plugin: "java"

    dependencies {
        compile project(":core")
        .......
        compile group: 'com.esotericsoftware', name: 'kryo', version: '3.0.3'

    }
}

project(":android") {
    apply plugin: "android"

    configurations { natives }

    dependencies {
        compile project(":core")
        ......
        compile group: 'com.esotericsoftware', name: 'kryo', version: '3.0.3'

    }
}