if (convertView == null) { // if it's not recycled, initialize some
                                // attributes

        btn = new Button(mContext);
}
else{
 btn = (Button) convertView;
}
        KeypadButton keypadButton = mButtons[position];

        switch(keypadButton.mCategory)
        {
        case MEMORYBUFFER:
            btn.setBackgroundResource(R.drawable.keypadmembuffer1);
            break;  
        case CLEAR:
            btn.setBackgroundResource(R.drawable.keypadclear1);
            break;  
        case NUMBER:
            btn.setBackgroundResource(R.drawable.keypad1);
            break;
        case OPERATOR:

            btn.setBackgroundResource(R.drawable.keypadop1);
            break;
        case OTHER: 
            btn.setBackgroundResource(R.drawable.keypadother1);
            break;
        case RESULT:
            btn.setWidth(8000);
            btn.setBackgroundResource(R.drawable.keypadresult1);
            break;
        case DUMMY:
            btn.setBackgroundResource(R.drawable.appvertical1);
            break;
        default:
            btn.setBackgroundResource(R.drawable.keypad1);
            break;
        }
        // Set OnClickListener of the button to mOnButtonClick
        if(keypadButton != KeypadButton.DUMMY)
            btn.setOnClickListener(mOnButtonClick);
        else
            btn.setClickable(false);
        // Set CalculatorButton enumeration as tag of the button so that we
        // will use this information from our main view to identify what to do
        btn.setTag(keypadButton);