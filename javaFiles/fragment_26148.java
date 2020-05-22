Map<String,List<FamilyMember>> map = list
              .stream()
              .collect(
                  Collectors.groupingBy(
                      FamilyInformation::getHouseName, 
                      Collectors.mapping(
                          family -> new FamilyMember(family.getFamilyMember()),
                          Collectors.toList()
                      )
                   )
               );