interface AnimalVolumeChangeListener{

    public void onAnimalVolumeChanged(int groupId, double previousVolume, double currentVolume);

}

interface TotalVolumeInterface{

    public Pair<LifecycleOwner,LiveData<Double>> getTotalVolume(int groupId);

    public void removeObservers(int groupId);

}