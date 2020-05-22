Arguments newArgs = new Arguments();
Arguments arguments = sampler.getArguments();

for (int i=0; i<arguments.getArgumentCount(); i++) {            
    Argument argument = arguments.getArgument(i);
    HTTPArgument newArg = new HTTPArgument();

    newArg.setName(arguments.getName());                            
    if (arguments.getName().equals("field_to_replace")) {
        newArg.setValue("new value");
    }
    else {
        newArg.setValue(arguments.getValue());
    }
    newArgs.addArgument(newArg);
}
sampler.setArguments(newArgs);