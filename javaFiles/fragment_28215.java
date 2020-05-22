List<String> allNames =
    list.stream() // this creates a Stream<LinkedHashMap<String,String>>
        .map(m->m.get("name")) // this maps the original Stream to a Stream<String>
                               // where each Map of the original Stream in mapped to the
                               // value of the "name" key in that Map
        .filter(Objects::nonNull) // this filters out any null values
        .collect(Collectors.toList()); // this collects the elements
                                       // of the Stream to a List