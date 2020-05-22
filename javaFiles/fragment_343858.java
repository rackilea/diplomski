widgets.stream()
       // Convert a stream of widgets to a stream of (type, widget)
       .flatMap(w -> w.getTypes().map(t->new AbstractMap.SimpleEntry<>(t, w)))
       // Grouping by the key, and do additional mapping to get the widget
       .collect(groupingBy(e->e.getKey(),
                mapping(e->e.getValue, 
                        collectingAndThen(toList(), l->l.toArray(new Widget[0])))));