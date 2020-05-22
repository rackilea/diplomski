jaxb {
    xsdDir = "src/main/resources/xsd"
    xjc {
        destinationDir = "build/generated-sources"
        taskClassname = "org.jvnet.jaxb2_commons.xjc.XJC2Task"
        generatePackage = "com.test.generated1"
        args = ["-Xinheritance", "-Xannotate"]
    }
}