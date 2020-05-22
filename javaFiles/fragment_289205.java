abstract class MyScript extends Script {
    def currentTaskName

    def task( taskObject ) {
        println "Trying to create task $taskObject"
    }

    def methodMissing( String name, def args ) {
        [ name: name, config: args ]
    }
}