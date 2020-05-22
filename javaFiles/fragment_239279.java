Executor conversionExec = ... ;

// ...

ConverterTask converterTask = new ConverterTask(someText);
converterTask.setOnSucceeded(e -> {
    String result = converterTask.getValue();
    // process result...
});
converterTask.setOnFailed(e -> {
    // code to execute in case of unhandled exception...
    // note you can get the exception with
    Throwable thingThatWentWrong = converterTask.getException();
    // ...
});

conversionExec.execute(converterTask);