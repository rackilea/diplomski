public class IncentiveAdapter extends ArrayAdapter<IncentiveItem> {

    private OnAdapterItemActionListener mListener;
    public IncentiveAdapter(Activity context, ArrayList<IncentiveItem> incentiveList, OnAdapterItemActionListener listener) {
        super(context, 0, incentiveList);
        mListener = listener;
    }
}