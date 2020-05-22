Map<String, String> states = new HashMap<String, String>();
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
{
    if(isChecked)
    {
        states.put(buttonView.getId(), buttonView..getText().toString());
    } else
    {
        states.remove(buttonView.getId());
    }
    if(states.size() >= 5)
    {
        // Your Condition
        // selectedStrings will now have all 5 checked CheckBox's Texts
        List<String> selectedStrings = new ArrayList<String>(states.values());
    }
}