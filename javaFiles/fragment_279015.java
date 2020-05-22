void setup() {
    mockApplicationContext()
}

def static mockApplicationContext() {
    GrailsUnitTestMixin.initGrailsApplication()
    Holders.grailsApplication = GrailsUnitTestMixin.grailsApplication
    Holders.metaClass.'static'.getApplicationContext = { ->
        return GrailsUnitTestMixin.applicationContext
    }
    Holders.metaClass.applicationContext.getBean = { bean ->
        return GrailsUnitTestMixin.messageSource
    }
}