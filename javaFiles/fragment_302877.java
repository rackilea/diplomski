private OnItemClicked onClick;

public interface OnItemClicked {
  void onItemClick(int position);
}

public SliderImageAdapter(Context context, List<Banner> bannerList, 
    OnItemClicked onClick) {

   this.bannerList = bannerList;
   this.onClick = onClick;
   this.context = context;
}