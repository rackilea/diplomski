public void onAllDayChanged() {
    selectedTimeRestriction = TimeRestriction.ALL_DAY;
    ajaxResponseRenderer.addRender("timeRecZone", timeRecZone);
}

public void onTimeRestrictedChanged() {
    selectedTimeRestriction = TimeRestriction.TIME_RESTRICTED;
    ajaxResponseRenderer.addRender("timeRecZone", timeRecZone);
}