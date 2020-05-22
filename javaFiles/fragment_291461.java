payment_method.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);


            if(checkedRadioButton.isChecked()) {

                if (checkedId == R.id.radio_prepaid)
                {
                    relativeLayout_card.setVisibility(View.GONE);  
                    cl_prepaid.setVisibility(View.VISIBLE); 

                } 
                else if (checkedId == R.id.radio_creditcard)
                {
                    cl_prepaid.setVisibility(View.GONE);  
                    relativeLayout_card.setVisibility(View.VISIBLE); 

                } 
            }
        }
    });