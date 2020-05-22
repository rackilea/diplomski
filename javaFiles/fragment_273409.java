test {
    systemProperty "org.d2ab.sequence.strict", "true"
}
task test2(type: Test) {
    systemProperty "org.d2ab.sequence.strict", "false"
} 
check.dependsOn test2