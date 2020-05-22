CityObjectImportTasklet(CityObjectRepository cityObjectRepository, cityId){
    this.cityObjectRepository = cityObjectRepository;
    this.cityId = cityId;
}

@Override 
public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
    List<CityObjectData> cityObjectData = getCityObjectDataSomehow(cityId);

    //In this case i do nothing
    if (cityObjectData.isEmpty) return;

    //disable all existent objects, to activate them later in case they're present
    cityObjectRepository.disableObjectsByCityId(cityId);

    List<CityObject> cityObjects = cityObjectRepository.findAllByCity(cityId);
    // Finds a matching existing cityObject and updates it with new data, if it's found
    updateCityObjects(cityObjects, cityObjectData);
}