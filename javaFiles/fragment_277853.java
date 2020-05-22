String variable;

/**
 * Constructor for objects of class Variable
 */
public Variable(final String variable)
{
    this.variable = variable;
}

/**
 * Create a ILOAD instance and pass it the variable name. 
 * ILOAD extends Instruction and overrides the method {@link Instruction#execute(Storage)}
 * which get as argument the {@link Storage} class and from which the value can be retrieved.  
 */
public void generateCode(final Program program) {
    program.append(new ILOAD(variable));
}