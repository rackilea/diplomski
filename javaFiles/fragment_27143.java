List<SomeOtherDataType> listAttr =
 someDTO.getlistAttr()
        .stream()
        .filter(o -> conditionToKeep)
        .collect(Collectors.toList());
someDTO.setListAttr(listAttr);