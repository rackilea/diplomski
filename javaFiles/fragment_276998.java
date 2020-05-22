//assume that "a" is your parent LinearLayout
ArrayList<CheckBox> allCheckBoxes = new ArrayList<>();

ArrayList<LinearLayout> linearLayouts = new ArrayList<>;
for(int i = 0; i < linearLayouts.size())
{
    if(a.getChildAt(i) instanceof LinearLayout)
    {
        linearLayouts.add((LinearLayout)(a.getChildAt(i)));
    }
}
for(LinearLayout linearLayout : linearLayouts)
{
    ArrayList<CheckBox> checkBoxes= new ArrayList<>;
    for(int i = 0; i < checkBoxes.size())
    {
        if(linearLayout.getChildAt(i) instanceof CheckBox)
        {
            checkBoxes.add((CheckBox)(linearLayout.getChildAt(i)));
        }
    }
    allCheckBoxes.addAll(checkBoxes);
}