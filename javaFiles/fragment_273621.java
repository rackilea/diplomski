list.stream().map(ele->{ele.setCurrency(0);return ele;}).collect(
        groupingBy(SomeClass::getDate,
                collectingAndThen(reducing((a, b) -> {
                    a.setPlayers(a.getPlayers() + b.getPlayers());
                    return a;
                }), Optional::get)))
        .values();