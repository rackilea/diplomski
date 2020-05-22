if (jRadioButton1.isSelected()){ 
    String temp; 
    try {
        for (int i = 0; i < 500; i++){ 
            temp = Integer.toString(Read.tempHigh[i]);

            if ( input.equals(temp) ) {   
                j.TextArea3.append(temp);
                j.TextArea3.append(input)
            }
        }
    }
    catch (NumberFormatException e){   
        jTextArea3.append("Please enter a number");
    }
}