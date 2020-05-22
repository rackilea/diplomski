@Override
public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    int layoutId;
    switch(viewType) {
       case 0:
         layoutId = R.layout.item_category_slider_viewed;
       break;
       case 1:
         layoutId = R.layout.item_category_slider_added;
       break;
       case 2:
         layoutId = R.layout.item_category_slider_browse_all;
       break;
       default:
         layoutId = R.layout.item_category_slider_regular;

    }

    View cardView = LayoutInflater.from(parent.getContext()).inflate(
                    layoutId, parent, false);

    return new HorizontalViewHolder(cardView, context);
}