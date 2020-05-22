run {
    // delegate the property 'mytestvalue' to the jvm 
    systemProperty "mytestvalue", System.getProperty("mytestvalue")

    // confirm that the property has been delegated
    println "mytestvalue: " + systemProperties["mytestvalue"]
}