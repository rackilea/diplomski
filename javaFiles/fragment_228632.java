task apiJar(type: Jar) {  
    from(sourceSets.main.output) {  
        include "com/company/sig/authorization/dto/**"
    }  
    archiveName = 'api.jar'
}