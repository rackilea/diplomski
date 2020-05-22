public static void main(String[] args) throws REXPMismatchException, REngineException, IOException{

        RConnection c = new RConnection();
        c.eval("source(\"DataPull.R\")");
        REXP r = c.parseAndEval("try(eval(myAdd()),silent=TRUE)");
        if (r.inherits("try-error")) System.err.println("Error: "+r.asString());
            else System.out.println("Success eval 2");  
    }