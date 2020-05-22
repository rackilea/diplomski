List<TimeZone> comboDropDownItem = new ArrayList<>();
    String[] ids = TimeZone.getAvailableIDs();
    for (String id : ids) {
        comboDropDownItem.add(TimeZone.getTimeZone(id));
    }
    Collections.sort(comboDropDownItem,
                    new Comparator<TimeZone>() {
        public int compare(TimeZone s1, TimeZone s2) {
            return s1.getRawOffset() - s2.getRawOffset();
        }
    }); // Need to sort the GMT timezone here after getTimeZone() method call
    for (TimeZone instance : comboDropDownItem) {
        System.out.println(getTimeZone(instance) + instance.getID());

    }