@Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        Object tag=buttonView.getTag();
        //could be integer, or primitive datatype
        //just make sure of type-casting
        if ( isChecked )
        {
            // perform logic, reduce value in final table or such
        }

    }