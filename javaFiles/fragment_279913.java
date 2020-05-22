map.addListener((Change<? extends Integer, ? extends Person> c) -> {
    if (c.wasAdded()) {
        list.add(c.getValueAdded());
    } else if (c.wasRemoved()) {
        list.remove(c.getValueRemoved());
    }
});