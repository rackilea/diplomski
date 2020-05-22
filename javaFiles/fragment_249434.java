apply plugin: "com.moowork.node"

task buildFrontend(type: YarnTask) {
    args = ['run', 'build']
}
tasks.build.dependsOn buildFrontend