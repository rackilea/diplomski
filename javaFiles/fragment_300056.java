public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ImageViewHolder> {

    private List<Popular> mPopular;

    // Use only one constructor.
    public PopularAdapter(List<Popular> mPopular) {
        this.mPopular = mPopular;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

      // Use the viewGroup i.e parent of the Adapter.
      Context context = viewGroup.getContext();
      LayoutInflater inflater = LayoutInflater.from(context);

      // Inflate the layout
      View v = inflater.inflate(R.layout.popular_items, viewGroup, false);
      return new ImageViewHolder(v);
    }

    ...

}