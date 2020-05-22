public class ListCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private LayoutInflater inflater;
private HomeView mHomeView;
private List<MediaCategoriesResponseDTO> datum;
private List<Media> listOfMedia;
CardView view;

public ListCategoryAdapter(HomeView mHomeView, List<MediaCategoriesResponseDTO> dt) {
    this.mHomeView = mHomeView;
    this.datum = dt;
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    inflater = LayoutInflater.from(parent.getContext());

    if (viewType == 1) {

        // inflate your first item layout & return that viewHolder
        view = (CardView) inflater.inflate(R.layout.list_item_media_banner, parent, false);


        return new MediaBannerViewHolder(mHomeView, view);

    } else {

        // inflate your second item layout & return that viewHolder

        view = (CardView) inflater.inflate(R.layout.list_item_media_category, parent, false);


        return new CategoryViewHolder(mHomeView, view);

    }

}

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if(position > 0) {

        ((CategoryViewHolder)holder).textViewCategoryName.setText(datum.get(position).getName());
        listOfMedia = datum.get(position).getMedias();
        RecyclerView horizontalMediaRecyclerView = view.findViewById(R.id.list_item_media);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager((Context)mHomeView, LinearLayoutManager.HORIZONTAL, false);
        horizontalMediaRecyclerView.setLayoutManager(mLayoutManager);
        horizontalMediaRecyclerView.setHasFixedSize(true);
        HomePresenter presenter = new HomePresenterImpl(mHomeView);
        presenter.loadMediaFeed(listOfMedia, horizontalMediaRecyclerView);
    }

    //Manipulate ViewPager View here
}

@Override
public int getItemCount() {
    return datum.size();
}

@Override
public int getItemViewType(int position) {
    if (position == 0) return 1;
    else return 2;
}

public static class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewCategoryName;

    public CategoryViewHolder(HomeView mHomeView, CardView cardView) {
        super(cardView);


        textViewCategoryName = (TextView) cardView.findViewById(R.id.textViewCategoryName);
    }
}

public static class MediaBannerViewHolder extends RecyclerView.ViewHolder {
    //The ViewPager code here
}