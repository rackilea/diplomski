FilteredList<LogTest> items = new FilteredList<>(originalItems);
 tableView.setItems(items);

 ... on update of filter UI items
 Predicate<LogTest> containsFoo = i -> i.getName().contains("foo");
 Predicate<LogTest> isSevere = i -> i.getLevel() == Level.SEVERE;
 Predicate<LogTest> filter = containsFoo.or(isSevere);

 items.setPredicate(filter);