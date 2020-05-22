jCalendar.getDayChooser().addPropertyChangeListener(
        //property sliderListener detects change of date in date chooser
        (PropertyChangeEvent evt)-> { dateChooserPropertChanged(evt);   });

private void dateChooserPropertChanged(PropertyChangeEvent evt) {

    if ("calendar".equals(evt.getPropertyName())
                || "date".equals(evt.getPropertyName())) {

        System.out.println("date is :"+ jCalendar.getDayChooser().getDate());
    }
}