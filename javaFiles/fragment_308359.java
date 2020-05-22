methods.removeAll(
    methods.stream ()
           .flatMap (hider -> methods.stream()
                                     .filter (hidden -> elements.hides(hider, hidden) || 
                                                        elements.overrides(hider, hidden, type))
                    )
           .collect(Collectors.toList())
);