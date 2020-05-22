js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if(js.getValueIsAdjusting()) {//slider value is still being adjusted
                    int num=(int)(Math.rint((double) js.getValue() / 10) * 10);//round to nearest 10
                    tf.setText(String.valueOf(num));//set textfield with value of nearest 10                  
                } else {//slider value has been set/no adjustments happenening
                    tf.setText(String.valueOf(js.getValue()));
                }

            }
        });