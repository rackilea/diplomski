apply plugin: 'application'
mainClassName = "com.mycompany.MyMain"
run {    
    /* Can pass all the properties: */
    systemProperties System.getProperties()

    /* Or just each by name: */
    systemProperty "myvariable", System.getProperty("myvariable")

    /* Need to split the space-delimited value in the exec.args */
    args System.getProperty("exec.args", "").split()    
}