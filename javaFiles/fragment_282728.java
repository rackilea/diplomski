private void decode(RuleSet[] rules, List<String> expressions, String condition) {
        for (int i = 0; i < rules.length; i++) {
            RuleSet item = rules[i];
            if (item.rules == null) {
                expressions.add(merge("(", item.field, item.operator, item.value, ")"));
                if (i != rules.length - 1) {
                    expressions.add(condition);
                }
            } else {
                condition = item.getCondition();
                expressions.add("(");
                decode(item.rules, expressions, condition);
                expressions.add(")");
            }
        }
    }
public String merge(String... strings) {
    StringBuilder result = new StringBuilder();
    for (String item : strings) {
        if (item != null) {
            result.append(item);
        }
    }
    return result.toString();
}