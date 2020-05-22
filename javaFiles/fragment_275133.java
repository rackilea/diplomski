List<Map<String, String>> result = list.stream()
            .map(map -> map.entrySet().stream()
                          .collect(Collectors.toMap(
                                  Map.Entry::getKey, 
                                  e -> e.getValue().toUpperCase())))
            .collect(Collectors.toList());

    System.out.println(result);
    // [{jpg=FIRSTIMAGE.JPG, png=FIRSTIMAGE.PNG}, {jpg=SECONDIMAGE.JPG, png=SECONDIMAGE.PNG}]