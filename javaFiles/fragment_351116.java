private IDataRetrieve dataRetriever;
@RequestMapping(method = RequestMethod.POST, value = "/api/{version-var}/getData")
public @ResponseBody ResponseDataDTO createReleaseFromTemplate(@PathVariable("version-var") Integer version, @RequestBody OperationsDetailsTDO details) {
    dataRetiever = DataRetrieverFactory.getDataTrieverByVersion(version);  //TODO, create a factory to get DataRetriever
    return dataRetiever.getData();
}