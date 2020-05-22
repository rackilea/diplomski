private static boolean isARule(String value)
  {
    for(dateRule rule : dateRule.values())
    {
      if(rule.toString().equals(value))
      {
        return true;
      }
    }
    return false;
  }