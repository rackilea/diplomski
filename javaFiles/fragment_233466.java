resultList.stream().
     filter(nestedDo -> nestedDo.getAttrib8() == 'S').
     filter(nestedDo ->  
         nestedDo.getFirstChildList().stream().anyMatch(c -> 
             ("ST2".equals(c.getAttrib18()) || 
             "ST3".equals(c.getAttrib18()) || 
             "ST4".equals(c.getAttrib18()) || 
             !"ST".equals(c.getAttrib18())) &&
             c.getGrandChildList() != null &&
             c.getGrandChildList().stream().anyMatch(gc -> {
                   date.after(gc.getAttrib19()) &&
                   date.before(gc.getAttrib43())
             }))
         ))).
     forEach(finalList.add(nestedDo));