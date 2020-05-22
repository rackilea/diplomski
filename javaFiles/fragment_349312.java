} else if (adapter.getSelectedDates().size() == 2) {
    final List<CalendarDay> dates = adapter.getSelectedDates();
    if (dates.get(0).isAfter(dates.get(1))) {
        dispatchOnRangeSelected(dates.get(1), dates.get(0));
    } else {
        dispatchOnRangeSelected(dates.get(0), dates.get(1));
    }
}