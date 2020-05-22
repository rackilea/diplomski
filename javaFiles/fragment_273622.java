list.stream()
    .map(ele->{ele.setCurrency(0);return ele;})
    .collect(toMap(SomeClass::getDate, Function.identity(), (a, b) -> {
        a.setPlayers(a.getPlayers() + b.getPlayers());
        return a;
    })).values();