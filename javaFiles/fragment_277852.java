/**
 * ILOAD instruction gets the valiable name for later retrieving of the value
 * in {@link ILOAD#execute(Storage)}
 * 
 * @param variable
 */
public ILOAD(final String variable)
{
    this.variable = variable;
}


/**
 * retrieve the variable value using its name from the storage and push it on the stack
 */
public void execute(Storage storage) {
    storage.getStack().push(storage.getVariables().load(variable));
}