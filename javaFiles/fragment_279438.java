@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case AnimalsArray.TOP:
                View top = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_top_layout, parent, false);
                return new Top(top);
            case AnimalsArray.MIDDLE:
                View data = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_middle_layout, parent, false);
                Middle middleHolder = new Middle(data);
                middleHolder.setAnimalVolumeChangeListener(mAnimalVolumeChangeListener);
                return middleHolder;
            case AnimalsArray.BOTTOM:
                View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_bottom_layout, parent, false);
                Bottom bottomHolder = new Bottom(footer);
                bottomHolder.setTotalVolumeInterface(mTotalVolumeInterface);
                return bottomHolder;

        }
        return null;
    }