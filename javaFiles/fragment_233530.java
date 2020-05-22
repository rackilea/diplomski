/**
* Triggers the save process as business logic and uses the result to determine
* what to return
* @return Navigation rule as String depending on the outcome of the save process
*/
public String save() {
   return processSave() ? navigationRuleSuccess : navigationRuleFailure;
}