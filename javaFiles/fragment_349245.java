task execute (type:JavaExec) {

    main = "com.myCompany.MyMain"
    classpath = sourceSets.main.runtimeClasspath 

    /* Can pass all the properties: */
    systemProperties System.getProperties()

    /* Or just each by name: */
    systemProperty "myvariable", System.getProperty("myvariable")

    /* Need to split the space-delimited value in the exec.args */
    args System.getProperty("exec.args", "").split()    
}