for (int n=0; n < rani.length; n++) {
    if (rani[n].equals("s")) {
        rani[n] = rani[n].replace("s","C/");
    } else if(rani[n].equals("r")) {     // ('else' missing)
        rani[n] = rani[n].replace("r","D/"); 
    } else {
        rani[n] = engine.eval(rani[n]);  // Semicolon missing!
        try {
            rani[n] = String.valueOf(engine.eval(rani[n]));
        } catch (ScriptException e) {
            e.printStackTrace(System.out);
        }
    } 
    System.out.println(rani[n]);
}