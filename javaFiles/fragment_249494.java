public class LastTransAdapter extends RecyclerView.Adapter<LastTransAdapter.ViewHolder> {
    private ArrayList<LastTransBean> lastTransBeans;
    private Context context;

    private MyCustomTextView textViewTitle, tv_Desc, tv_Date, tv_Amount;
    private LinearLayout layout1;
    private View customView, myView;

    private LayoutParams layoutParams;

    private PopupWindow popUpWindow = null;

    private RelativeLayout layout;

    private int MONTHHEADER = 1;
    private int DATAVIEW = 2;


    public LastTransAdapter(ArrayList<LastTransBean> lastTransBeans, Context context, View myView, RelativeLayout layout) {
        this.lastTransBeans = lastTransBeans;
        this.context = context;
        this.myView = myView;
        this.layout = layout;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        if (i == DATAVIEW) {

             // view for normal data.


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_last_transactions, viewGroup, false);
            return new ViewHolder(view);
        } else {

            // view type for month or date header

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_month_header, viewGroup, false);
            return new ViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        final int position = i;

        if (viewHolder.getItemViewType() == DATAVIEW) {

            //fill data for normal view


        } else {
            //set your date or month header
        }

    }

    @Override
    public int getItemCount() {
        return lastTransBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (lastTransBeans.get(position).getMonth()) {
            return MONTHHEADER;
        } else {
            return DATAVIEW;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MyCustomTextView transtile, transdate, transamont, tv_monthHeader;
        LinearLayout acctype;
        CardView mlastTransCardView;


        public ViewHolder(View itemView) {
            super(itemView);

           // cast all the textviews , buttonsetc used ion view Holder.

        }
    }
}