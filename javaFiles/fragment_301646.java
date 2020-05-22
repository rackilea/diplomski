String actionName = methodName.trim().toLower(Locale.US));
ClaimAction action = CLAIM_ACTION_MAPPING.get(actionName);
if (action != null)
{
    action.execute(parameters);
}
else
{
    // Error case, presumably.
}