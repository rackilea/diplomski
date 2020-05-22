int count = spinnerContainer.getChildCount();
for(int i =0;i<count;i++)
{
    View v = spinnerContainer.getChildAt(i);
    if(v instanceof Spinner)
    {
        ((Spinner)v).getSelectedItem()
    }
}