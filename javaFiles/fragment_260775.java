public class PlaceCardClickHandler implements 
 FixedPlaceListAdapter.FixedPlaceListAdapterOnclickHandler,
    PlaceListAdapter.PlaceListAdapterOnclickHandler {
Context mContext;

public PlaceCardClickHandler(Context mContext) {
    this.mContext = mContext;
}

@Override
public void onClick(String id) {
    Intent intentToStartDetail = new Intent(mContext, PlaceDetailActivity.class);
    intentToStartDetail.putExtra("id", id);
    mContext.startActivity(intentToStartDetail);
}