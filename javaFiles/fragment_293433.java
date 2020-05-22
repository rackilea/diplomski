public static void addButtonListeners(View v, OnClickListener clickListener)
{
    ViewGroup widgets = (ViewGroup) v;
    for(int i = 0; i < widgets.getChildCount(); ++i)
    {
        View child = widgets.getChildAt(i);
        if (child instanceof Button)
        {
            Button nextButton = (Button) child;
            nextButton.setOnClickListener(clickListener);
        }
    }
}