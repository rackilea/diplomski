checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
   {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            if ( isChecked )
            {

                prevChecked = true;
        Log.d("CHECKBOX","Previously Checked = "+prevChecked);
            }else{

                prevChecked = false;
        Log.d("CHECKBOX","Previously Checked = "+prevChecked);

            }

        }
    });