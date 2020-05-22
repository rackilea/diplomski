return elements.parallelStream()
        .filter(url -> !url.isEmpty())
        .filter(url -> isLink(url))
        .distinct()
        .map(Link::new)
        .collect(Collectors.toList());