rule "Rule #1"
when
    c: Client( buyHist: buyingHistory contains "snowboard" ) 
    s: Season( season == "winter" )
then
    System.out.println( buyHist );
    modify( c ){ setInterestedIn("skiing") }
    System.out.println("Client is interested in skiing");
end

rule "Rule #2"
when
    c: Client( interestedIn == "skiing",
               buyingHistory not contains "ski jacket" ) 
then
    System.out.println("Ski jacket is recommended");
end