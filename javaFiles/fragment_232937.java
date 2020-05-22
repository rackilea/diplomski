....
DateWidget widget = new DateWidget(driver, "yearId", "monthId", "dayId");
....

public void testYearNumeric() {
        widget.setYear("aa");
        widget.submit();
        //Logic to determine Error message shows up

        // ... and day
        widget.setDay("bb");
        widget.submit();
        //Logic to determine Error message shows up
    }