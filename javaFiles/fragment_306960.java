List<SomeClass> someList2 = 
someList1.stream()
         .map(i -> {                    
                    SomeClass someObj = new SomeClass();
                    someObj.setField(i.getField());  
                    return someObj;
                  }
         )
        .collect(Collectors.toList());