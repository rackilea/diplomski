//SomeAndroidActivity
    private void addRadioButtons(int numButtons) {
      for(int i = 0; i < numButtons; i++)
        //instantiate...
        RadioButton radioButton = new RadioButton(this);

        //set the values that you would otherwise hardcode in the xml...
        radioButton.setLayoutParams 
          (new LayoutParams 
          (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //label the button...
        radioButton.setText("Radio Button #" + i);
        radioButton.setId(i);

        //add it to the group.
        radioGroup.addView(radioButton, i);
      }
    }