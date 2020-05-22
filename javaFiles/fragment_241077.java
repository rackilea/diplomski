public void execute(JobExecutionContext context) throws JobExecutionException {
    ...
    Stations.setInstance(targetGet.request(...));
}

public List<Station> getStations(){
    return Stations.getInstance().getStations();
}