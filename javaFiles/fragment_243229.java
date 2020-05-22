rule "temperature"
    when
    $n1 : CTDSIRSNotification( temperature > 38 || temperature < 36 )
    then
    $n1.setCounter($n1.getCounter()+1);
    System.out.println($n1.getCounter()+", temperature");
    update($n1);
end

rule "respRateAndPaCo2"
    when
    $n1 : CTDSIRSNotification( respRate > 20 || paCo2 < 32 )
    then
    $n1.setCounter($n1.getCounter()+1);
    System.out.println($n1.getCounter()+", respRateAndPaCo2");
    update($n1);
end

rule "wbCellCountAndimmatureBand"
    when
    $n1 : CTDSIRSNotification( wbCellCount > 12000 || wbCellCount < 4000 || immatureBand > 10 )
    then 
    $n1.setCounter($n1.getCounter()+1);
    System.out.println($n1.getCounter()+", wbCellCountAndimmatureBand");
    update($n1);
end 

rule "sirsNotification"
    when
    $n1 : CTDSIRSNotification( counter >= 3 )
    then 
    System.out.println($n1.getCounter()+", Alert for SIRS");
end