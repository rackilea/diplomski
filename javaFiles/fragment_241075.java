public void execute(JobExecutionContext context) throws JobExecutionException {
    ...
    Stations.getInstance().setStations(targetGet.request(...));
}

public List<Station> getStations(){
    return Stations.getInstance().getStations();
}