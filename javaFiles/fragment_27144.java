someDTO.getlistAttr()
       .removeIf(o -> {
                        Bar bar = o.getFoo().getBar();
                        if (bar != null){
                            List<FooBar> fooBars = bar.getList(); 
                            if (fooBars.contains(...)){
                                 return true; // I remove in this case
                            }
                        }
                        return false; // in any other case I keep
                      }
                );