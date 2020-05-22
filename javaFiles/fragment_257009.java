private class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            int max = 0;
            int total = 0;
            // Get the slider value.
            int slider1Val = slider1.getValue();
            int slider2Val = slider2.getValue();
            if (slider1Val > slider2Val) {
                max = slider1Val;
            } else {
                max = slider2Val;
            }
            total = slider2Val + slider1Val;
            // Store the total sound level in its display field.
            totalSound.setText(Integer.toString(total));

            // Store the max sound level in its display field.
            maxSound.setText(Integer.toString(max));
        }
    }