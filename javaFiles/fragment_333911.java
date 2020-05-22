static ConditionBuilder<Integer> condition1(ConditionBuilder<Integer> parent) {
  parent.setCondition(l -> l == 0);
  return parent;
}

static ConditionBuilder<String> condition2(ConditionBuilder<String> parent) {
  parent.setCondition(l -> l.length() > 3);
  return parent;
}