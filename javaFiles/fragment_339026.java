configurations.each { conf ->
    println "Attributes of $conf:"
    conf.attributes.keySet().each { attr ->
        println "\t$attr -> ${conf.attributes.getAttribute(attr)}"
    }
}