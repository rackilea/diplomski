ListDataProvider<Integer> dp = new ListDataProvider<>(cbItems);
// the first param is function that returns the value to sort
// in case of Integer it is that Integer itself.
dp.setSortOrder(i -> {return i;}, SortDirection.ASCENDING);
ComboBox<Integer> combo = new ComboBox<>();
combo.setDataProvider(dp);