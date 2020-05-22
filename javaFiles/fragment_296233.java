global MyService service;

rule ruleone
when
    $fact : AppFact( name == "abcd")
then
    boolean b1= $fact.id[422] && $fact.id[423]  &&  $fact.id[372]  && $fact.ruleId[373];
    boolean b2= b1 && $fact.id[272];
    boolean b3= b1 && $fact.id[273];

    service.notifyValues(b1, b2, b3);
end