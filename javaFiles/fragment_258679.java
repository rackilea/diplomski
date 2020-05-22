public class SimiliarPlantsAdapter extends RecyclerView.Adapter<SimiliarPlantsAdapter.PlantViewHolder>{

  private OnItemClickListener listener;

    public interface OnItemClickListener {
            void onTitleClicked(int position, String title, View clickedview);
            void onImageClicked(int position, View clickedview);
        }

    }
    public SimiliarPlantsAdapter(ArrayList<Plant> plants,Context context, OnItemClickListener listener ) {
        this.plants = plants;
        this.context = context;
        this.listener = listener;
    }