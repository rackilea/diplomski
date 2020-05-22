//We retrieve the stored Object and cast it to a String array
final Object recipient = (String[]) getLastNonConfigurationInstance();

//in case the state changes again before the code that sets the directories is run
catcher = recipient;

//if there was any stored data, we can now reinstate the list adapter where the
//directoryList was originally being used.
if(recipient != null)
{
    returnedDirectories.setAdapter(new ArrayAdapter<String>(
        this.getBaseContext(),
        R.layout.simple_list_item_small,
        (String[])recipient));
}