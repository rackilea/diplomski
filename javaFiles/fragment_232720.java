rule "Rule 1"
when
  $m : MyObject(counted == false)
  $c : Calculator
then
  modify($m) { setCounted(true); }
  $c.count($m);
end

rule "Rule 2"
when
  not  MyObject(counted == false)
  $m : MyObject(numberOfExecutions > ($c.totalExecutions * 0.05))
  $c : Calculator
then
  $m.markBiggerThan5();
end