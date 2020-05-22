final JSlider slider = new JSlider();
slider.setModel(new MyBoundedRangeModel(0, 0, -100, 100));
ChangeListener l = new ChangeListener() {

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e instanceof MyChangeEvent) {
            MyChangeEvent me = (MyChangeEvent) e;
            if (me.getChangedProperties().contains("value")) {
               System.out.println("new value: " + 
                    ((BoundedRangeModel) e.getSource()).getValue()); 
            }
            if (me.getChangedProperties().contains("maximum")) {
                System.out.println("new max: " + 
                    ((BoundedRangeModel) e.getSource()).getMaximum()); 
            }
        } else {
            // do something else or nothing
        }
    }
};
slider.getModel().addChangeListener(l);