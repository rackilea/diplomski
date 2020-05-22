int num = 
    list.stream()
        .filter(x->x.getType().getTypeId()==Type.getTypeId())
        .map(x->x.getNum())
        .findFirst()
        .orElse(0); // default value in case the Stream is empty after the filtering