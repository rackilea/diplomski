subGoalSpinner.setOnItemSelectedListener(new OnItemSelectedListener() 
{
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
    {
        valueINeed = subGoalSpinner.getSelectedItemPosition();
        updateView(valueINeed);
    }
}