List<?> finalList = resultList.stream()
  .anyMatch(nestedDo -> nestedDo.getAttrib8() == 'S' &&
    nestedDo.getFirstChildList().stream().anyMatch(c -> 
          "ST2".equals(c.getAttrib18())
       || "ST3".equals(c.getAttrib18())
       || "ST4".equals(c.getAttrib18()) 
          && c.getGrandChildList()!=null
          && c.getGrandChildList().stream().anyMatch(gc ->
              date.after(gc.getAttrib19()) && date.before(gc.getAttrib43()))
  ))? resultList: Collections.emptyList();