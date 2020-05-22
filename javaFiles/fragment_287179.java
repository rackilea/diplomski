list = 
    Arrays.stream(SubjectAreaMappings.values())
          .filter(s -> page.equals(s.toString()))
          .flatMap(s -> Arrays.stream(s.getCodes())
                              .map(code -> areaDAO.getData(context, code)))
          .collect(toList());