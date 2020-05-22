Map<String, List<CustomRequest>> result = 
    request.paramList()
          .stream()
          .collect(Collectors.groupingBy(Param::getParamId, 
                                         Collector.of(ArrayList::new, 
                                                     (l,i)->l.addAll(i.dataParams().stream().map(r -> customBuildMethod(i.dataParamId(), r, request)).collect(Collectors.toList())),
                                                     (l1,l2)->{l1.addAll(l2);return l1;})));