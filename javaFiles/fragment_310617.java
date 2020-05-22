public static void main(String[] args) {

    try {
        F.initSymbols(null);
        EvalUtilities util = new EvalUtilities();

        StringBufferWriter buf = new StringBufferWriter();
        String input = "Solve[{a==10,c==20,a+b==c},{a,b,c}]";  
        IExpr result = util.evaluate(input);
        OutputFormFactory.get().convert(buf, result);
        String output = buf.toString();
        System.out.println("Evaluation for " + input + " is " + output);

    } catch (final Exception e) {
        e.printStackTrace();
    } finally {
        // Call terminate() only one time at the end of the program  
        ComputerThreads.terminate();
    }

}