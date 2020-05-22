//Find Solute
try{if(iterations == 0){
    remaining = Whitespace.removePreceding(remaining);
    String unused = remaining.substring(0);
    InterpretInput solute = new InterpretInput(remaining);

    // HERE - calls itself again, prior to incrementing
    // iterations variable
    solute.begin();

    solute.fixSoluteAmount();
    soluteAmount = solute.getSolventAmount();
    isSolution = true;

    // HERE - iterations is incremented, but too late
    ++iterations;
}}catch(Exception ex){
}