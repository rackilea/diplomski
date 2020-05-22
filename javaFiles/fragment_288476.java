Map<String, Element> elMap = new HashMap<>();
elMap.put("3", new Element("3"));
elMap.put("2", new Element("2"));
elMap.put("1", new Element("1"));

List<Element> elList = elMap.values()
        .stream()
        .sorted((e1, e2) -> {
            return e1.getSortField().compareTo(e2.getSortField());
        })
        .collect(Collectors.toList());
System.out.println(elList);