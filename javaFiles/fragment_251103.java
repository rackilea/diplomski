DatePicker picker = new DatePicker();

// you may not want the controls to manipulate time, they are on by default however
picker.setHideTimeControls(true);

// optional: the format you want the date to be in for the user
picker.formatProperty().setValue("yyyy/MM/dd HH:mm:ss.SSS");

// optional: set timezone
picker.timezoneProperty().setValue(TimeZone.getTimeZone("CET"));

// optional: set locale
picker.localeProperty().setValue(new Locale("nl"));

// react to changes
picker.timestampProperty().addListener(new ChangeListener<Long>() {
    @Override
    public void changed(ObservableValue<? extends Long> arg0, Long oldValue, Long newValue) {
        // do something
    }
});