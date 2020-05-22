ObservableList<String> newList = 
        list.stream()
            .filter(x -> x.startsWith("a"))
            .collect(Collector.of(
                FXCollections::observableArrayList,
                ObservableList::add,
                (l1, l2) -> { l1.addAll(l2); return l1; })
            );