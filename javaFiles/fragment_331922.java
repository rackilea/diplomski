public void calculate()
{        
        if(String.valueOf(mEditText1.getText()).length() == 0)    
        mEditText1.setError("Required only alphabets");    
        else if(String.valueOf(mEditText2.getText()).length() == 0)    
        mEditText2.setError("Required only alphabets");    
        else if(String.valueOf(mEditText3.getText()).length() == 0)
            mEditText3.setError("Required only alphabets");    
        else{
        Double value1 = Double.parseDouble(String.valueOf(mEditText1.getText()));
        Double value2 = Double.parseDouble(String.valueOf(mEditText2.getText()));
        Double value3 =    Double.parseDouble(String.valueOf(mEditText3.getText()));
        calculatedValue = (value2 * value3) / value1;
        mTextView.setText(calculatedValue.toString());
       }
 }