//reference to context
ExecutionContext jdbcExecutionContext = Akka.system().dispatchers()
     .lookup("jdbc-execution-context");

return promise(() -> {
    //db call
}, jdbcExecutionContext)
.map(callResult -> ok(callResult));