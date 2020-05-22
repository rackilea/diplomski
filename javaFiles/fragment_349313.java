case SELECTION_MODE_RANGE: {
        adapter.setDateSelected(date, nowSelected);
        if (adapter.getSelectedDates().size() > 2) {
            adapter.clearSelections();
            adapter.setDateSelected(date, nowSelected);  //  re-set because adapter has been cleared
            dispatchOnDateSelected(date, nowSelected);
        } else if (adapter.getSelectedDates().size() == 2) {
            final List<CalendarDay> dates = adapter.getSelectedDates();
            if (nowSelected) { // when selecting
                if (dates.get(0).isAfter(dates.get(1))) {
                    dispatchOnRangeSelected(dates.get(1), dates.get(0));
                } else {
                    dispatchOnRangeSelected(dates.get(0), dates.get(1));
                }
            } else { // in case range initially consisted of 3 dates, and now deselection happens
                adapter.clearSelections();
                adapter.setDateSelected(date, nowSelected);  //  re-set because adapter has been cleared
                dispatchOnDateSelected(date, nowSelected);
            }
        } else {
            if (nowSelected) {
                adapter.setDateSelected(date, nowSelected);
                dispatchOnDateSelected(date, nowSelected);
            } else { // in case range initially consisted of 2 dates, and now deselection happens
                adapter.clearSelections();
                adapter.setDateSelected(date, nowSelected);  //  re-set because adapter has been cleared
                dispatchOnDateSelected(date, nowSelected);
            }
        }
    }
    break;