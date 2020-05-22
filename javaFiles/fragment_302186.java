Enumeration e = jSlider.getLabelTable().keys();

    while (e.hasMoreElements()) {
        Integer i = (Integer) e.nextElement();
        JLabel label = (JLabel) jSlider.getLabelTable().get(i);
        label.setText(String.valueOf(i / 1000));          
    }