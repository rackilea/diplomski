cal = new JCalendar();
    cal.setWeekOfYearVisible(false);
    cal.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        System.out.println(e.getPropertyName()
                + ": " + e.getNewValue());

    }
});