List<DspInfoEntity> dspInfoList = 
    appLaunchMappingDtoList.stream() // Stream<AppLaunchMappingDto>
                           .map(AppLaunchMappingDto::getDspId) // Stream<Integer>
                           .filter(dspInfoEntityMap::containsKey)
                           .map(dspInfoEntityMap::get) // Stream<DspInfoEntity>
                           .collect(Collectors.toList()); // List<DspInfoEntity>