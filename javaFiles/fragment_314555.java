public Voertuig(/*  ...your arguments here... */) {
    this.nummerplaat = div.getNummerplaat();
    this.Zitplaatsen = Zitplaatsen;
    try {
        //...
        //code in the try...
        //...
    } catch (MensException e) {
        //System.out.println(e.getMessage());
        //use a logger, not System.out
        //in case you still want to use System.out
        //then at least use the code shown below
        //e.printStackTrace(System.out);
        //line above commented since there's no need to log
        //and rethrow the exception
        //the exception will be handled by the highest level execution
        //and there it should be logged or use another strategy
        throw e;
    } 
}