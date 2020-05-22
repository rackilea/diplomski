for (ParseTreeMatch match : matches) {
  ConditionContext condition = (ConditionContext)match.get("condition");
  if (condition.assignment() == null) {
    // TODO: report error here
  }
}