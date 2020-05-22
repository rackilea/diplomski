List<DropDown> result =  
    getter(id).stream()
              .map( o -> { if (o instanceof Person){
                             Person p = (Person) o;
                             return new PDropDown(p.getFirstName(), p.getLastName()); 
                          }
                          throw new IllegalArgumentException("o "+ o + " is not a Person");
                         })
              .collect(Collectors.toList());