List<DspInfoEntity> dspInfoList = 
    appLaunchMappingDtoList.stream() // Stream<AppLaunchMappingDto>
                           .map(AppLaunchMappingDto::getDspId) // Stream<Integer>
                           .map(dspInfoEntityMap::get) // Stream<DspInfoEntity>
                           .filter(Objects::nonNull)
                           .collect(Collectors.toList()); // List<DspInfoEntity>