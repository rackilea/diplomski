static class Middle extends RecyclerView.ViewHolder {
    Context context;
    EditText weight;
    EditText quantity;
    TextView volume;
    AnimalVolumeChangeListener animalVolumeChangeListener;

    Middle(final View itemView) {
        super(itemView);
        context = itemView.getContext();
        volume = (EditText) itemView.findViewById(R.id.volume);
        weight = (EditText) itemView.findViewById(R.id.weight);
        quantity= (EditText) itemView.findViewById(R.id.quantity);
    }

    public void setAnimalVolumeChangeListener(AnimalVolumeChangeListener animalVolumeChangeListener) {
        this.animalVolumeChangeListener = animalVolumeChangeListener;
    }

}

static class Bottom extends RecyclerView.ViewHolder {
    TextView volume;
    TotalVolumeInterface totalVolumeInterface;

    Bottom(View itemView) {
        super(itemView);
        volume = (TextView) itemView.findViewById(R.id.volumeText);


    }

    public void setTotalVolumeInterface(TotalVolumeInterface totalVolumeInterface) {
        this.totalVolumeInterface = totalVolumeInterface;
    }

}