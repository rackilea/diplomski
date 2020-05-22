np5.setOnValueChangedListener(new OnValueChangeListener()
        {
            public void onValueChange(NumberPicker picker, int oldVal, 
                int newVal)
            {
             //10 * 0 = 0;
             //10 * 1 = 10;
             //10 * 2 = 20;
             //etc
                current_weight_view.setText("" + (newVal * 10)); 
            }        
        });