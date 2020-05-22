public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {


    public class AnimalViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        TextView name;



        NewsItemViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            ///do what you want when clicking on your animal object
        }

    }


    public List<Animal> animalList = new ArrayList<>();

    public AnimalAdapter(List<Animal> animalList){
        this.animalList = animalList;


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_animal, viewGroup, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int i) {

        holder.name.setText(animalList.get(i).getName());

    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}