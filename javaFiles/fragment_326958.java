rule "OverWeightTest"
dialect "mvel"
when
    $w: Weight() from new Weight(200, Weight.Unit.LBS)
    $person : Person( weight.greaterThan($w) )
then
    System.out.println($person + " is overweight!");
end