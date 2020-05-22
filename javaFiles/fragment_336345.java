Map<String, List<Map<String, String>>> afterFormatting = 
     beforeFormatting.stream()
                     .collect(Collectors.groupingBy(map -> map.get("nom"), 
                           Collectors.mapping(map -> { 
                                Map<String, String> temp = new HashMap<>(map);
                                temp.remove("nom");
                               return temp;
                     }, Collectors.toList())));