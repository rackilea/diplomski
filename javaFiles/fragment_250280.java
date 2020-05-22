@ProcessAdditions
void processAdditions(MApplication app)
{
  String value = app.getPersistedState().get("myKey");

  if (value == null)  // Starting with nothing to restore
   {
     app.getPersistedState().put("myKey", "set");

     ...
   }
  else
   {
     ... persisted state exists
   }

}