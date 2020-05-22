jSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                JSlider source = (JSlider)e.getSource();
                if(!source.getValueIsAdjusting())
                {
                    //textField.setText(String.valueOf(source.getValue()));
                    int gain = source.getValue();
                    //System.out.println("***** GAIN ***** "+gain);
                    GetGain g = new GetGain(gain);
                }
            }
        });