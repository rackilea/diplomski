checkBoxes[i].setOnClickListener(new MyOnClickListener(checkBoxes[i]));

...

class MyOnClickListener
    implements OnClickListener
{
    private CheckBox checkBox;
    public MyOnClickListener( CheckBox box )
    {
        // maintain a reference to the CheckBox so we can see if it's checked!
        this.checkBox = box; 
    }

    public void onClick(View v)
    {
        // if this.checkBox is checked, then...
    }
}