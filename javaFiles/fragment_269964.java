public String onFlowProcess(FlowEvent event)
{
  if (!event.getOldStep().equals("competitionId"))
  {
    return event.getNewStep();
  }
  if (validationPassed())
  {
    return event.getNewStep();
  }
  else
  {
    return event.getOldStep();
  }
}

private boolean validationPassed()
{
  // do your validation here.
  // return true if validation passed
}