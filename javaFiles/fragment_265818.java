TypeMap<DogData, DogInfo> tm = mm.getTypeMap(DogData.class, DogInfo.class);
    List<Mapping> list = tm.getMappings();
    for (Mapping m : list)
    {
        System.out.println(m);
    }