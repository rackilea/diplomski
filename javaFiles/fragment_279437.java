class Animal_Volume_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<AnimalsArray> mList;
    private TotalVolumeInterface mTotalVolumeInterface;
    private AnimalVolumeChangeListener mAnimalVolumeChangeListener;
    private double volume = 0;

    public Animal_Volume_Adapter(ArrayList<AnimalsArray> list,
                                 TotalVolumeInterface totalVolumeInterface,
                                 AnimalVolumeChangeListener animalVolumeChangeListener) {
        this.mList = list;
        this.mTotalVolumeInterface = totalVolumeInterface;
        this.mAnimalVolumeChangeListener = animalVolumeChangeListener;
    }