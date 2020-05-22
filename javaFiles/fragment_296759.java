Set<String> only = Marks.stream()
    .map(Mark::search)
    .filter(mark -> ENUM1.getData().equals(mark) 
                    || ENUM2.getData().equals(mark) 
                    || ENUM3.getData().equals(mark))
    .map(macro -> macro.equals(ENUM3.getData()) ? "Java" : macro)
    .collect(Collectors.toSet());