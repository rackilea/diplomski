List<RuleModel> toBeAdded = new ArrayList<RuleModel>();

  if(currentReceived.getStatus()!="D")
  { 
      //replace the existing rule with the new one
      itReceivedRulesExisting.remove();
      toBeAdded.add(currentReceived);
  } 
  else
  {
      itReceivedRulesExisting.remove(); 
  }

  ...
  // after the loop terminated:
  receivedRulesExisting.addAll(toBeAdded);