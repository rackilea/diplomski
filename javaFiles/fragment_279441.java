public class SetupRecyclerClass extends AppCompatActivity implements TotalVolumeInterface, AnimalVolumeChangeListener{

    HashMap<Integer, MutableLiveData<Double>> mTotalVolumesMap = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<AnimalsArray> animalsArrayArrayList = new ArrayList<>();
        Animal_Volume_Adapter adapter = new Animal_Volume_Adapter(animalsArrayArrayList,this, this);
    }

    @Override
    public Pair<LifecycleOwner, LiveData<Double>> getTotalVolume(int groupId) {

        if(mTotalVolumesMap.get(groupId) == null){
            mTotalVolumesMap.put(groupId,new MutableLiveData<>(0.0));
        }

        return new Pair<>(this,mTotalVolumesMap.get(groupId));
    }

    @Override
    public void removeObservers(int groupId) {

        mTotalVolumesMap.get(groupId).removeObservers(this);

    }

    @Override
    public void onAnimalVolumeChanged(int groupId, double previousVolume, double currentVolume) {
        if(mTotalVolumesMap.get(groupId) == null){
            mTotalVolumesMap.put(groupId,new MutableLiveData<>(0.0));
        }

        double newTotalVolume = (mTotalVolumesMap.get(groupId).getValue()-previousVolume)+currentVolume;
        mTotalVolumesMap.get(groupId).setValue(newTotalVolume);
    }
}