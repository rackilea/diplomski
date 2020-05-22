REngine re = REngine.getLastEngine();
if (re==null){
    re = REngine.engineForClass("org.rosuda.REngine.JRI.JRIEngine",
                                new String [] {"--vanilla"},
                                new REngineStdOutput(), // R console output
                                false); 
}    

re.parseAndEval("myfunction <- function() {myvar <<- \"something\"; print(paste0(\"logging 'myvar' in R:\", myvar));}");   
re.parseAndEval("myfunction()");

REXP jriObj = re.parseAndEval("myvar");
String myvar = jriObj.asString();
System.out.println("logging 'myvar' in Java: " + myvar);