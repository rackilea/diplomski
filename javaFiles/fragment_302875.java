private OnItemClicked onClick;

public interface OnItemClicked {
    void onItemClick(int position);
}

public SliderImageAdapter(Context context, List<Banner> bannerList) {

    this.bannerList = bannerList;
    this.context = context;
}