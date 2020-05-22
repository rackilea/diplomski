Iterator itf = rete.listFacts();
while(itf.hasNext()){
    Fact fact = (Fact)itf.next();
    if( fact.getName().equals("MAIN::recommendation")){ 
    System.out.println( "package: " + 
                        fact.getSlotValue( "package" ));
    System.out.println( "explanation: " +
                        fact.getSlotValue( "explanation" ) );
    }
}