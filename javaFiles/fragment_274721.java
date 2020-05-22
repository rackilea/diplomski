// get a reference to the function
REXP fn = eng.parseAndEval("function(x) x ^ 3 - x ^ 2 - 4 * x + 2", null, false);

// create a call and evaluate it
REXP res = eng.eval(new REXPLanguage(new RList( new REXP[] {
             fn, new REXPInteger(5)
                    })), null, true);
System.out.println("Result: " + res.asDouble());