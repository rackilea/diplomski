class MyService{
    static transactional = false
    def grailsApplication

    @AuditLog
    def method1() {
        println "method1 called"
        grailsApplication.mainContext.myService.method2()
        //method2()
    }
    @AuditLog
    def method2() {
        println "method2 called"
    }
}