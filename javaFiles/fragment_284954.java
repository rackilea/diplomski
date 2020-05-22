rule "calcitonin evaluation"
when
  $p : Patient($labtestItem : labtests)
  $lti: LabTestItem($result : result, parseFloat($result.substring(1,(result.length)-1)) > 8.4) from $labtestItem.get("calcitonin").get(0)
then
  $lti.setAbnormalIndicator("high");
  $lti.setAttentionLevel("important");
  modify($p){}
end