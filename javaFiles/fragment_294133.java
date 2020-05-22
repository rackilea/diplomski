public class StockCardAdapter extends 

RecyclerView.Adapter<StockCardAdapter.ViewHolder> {

 public static class ViewHolder extends RecyclerView.ViewHolder   {

    protected RelativeLayout mCardBodyLayout;
    protected TextView mTitleTextView; 

    public ViewHolder(View v) {
        super(v);
        mCardBodyLayout = (RelativeLayout) v.findViewById(R.id.card_body);
        mTitleTextView = (TextView) v.findViewById(R.id.card_title); 
    }

    public void bindData(StockCategoryModel data, Context ctx, View.OnClickListener listener) {
        this.mTitleTextView.setText(data.getCategoryName());

        TableLayout tableLayout = new TableLayout(ctx);

        int rows = data.getStockList().size();

        for (int r = 0; r < rows; r++) {
            TableRow row = new TableRow(ctx);

            TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams (TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            rowParams.setMargins(0, 0, 0, 16);
            row.setLayoutParams(rowParams);

            LinearLayout rl = new LinearLayout(ctx);
            rl.setOrientation(LinearLayout.VERTICAL);

            Integer priceColor = SharedUtilities.getColor(data.getStockList().get(r).priceChange, ctx);

            //price row
            LinearLayout priceLayout = new LinearLayout(ctx);
            priceLayout.setOrientation(LinearLayout.HORIZONTAL);
            priceLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            priceLayout.setWeightSum(4);

            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

            final TextView price_text = new TextView(ctx);
            price_text.setTag("priceTag");
            price_text.setText(data.getStockList().get(r).price);
            price_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            price_text.setTextColor(Color.BLACK);
            price_text.setLayoutParams(textViewParams);
            priceLayout.addView(price_text);

            //company row
            final TextView name_text = new TextView(ctx);
            name_text.setText(data.getStockList().get(r).company); 
            name_text.setTextColor(Color.GRAY);
            name_text.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
            name_text.setMaxWidth(700);
            name_text.setEllipsize(TextUtils.TruncateAt.END);
            name_text.setMaxLines(1);
            name_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            rl.addView(priceLayout);
            rl.addView(name_text);
            row.addView(rl);

            tableLayout.setStretchAllColumns(true);
            tableLayout.addView(row);

            // *ADDED* set the listener directly to each row
            row.setOnClickListener(listener);

        }
        mCardBodyLayout.addView(tableLayout);
    }

}

private List<StockCategoryModel> mDataset;
private Context mContext;

// Constructor
public StockCardAdapter(List<StockCategoryModel> dataset, Context ctx) {
    this.mDataset = dataset;
    this.mContext = ctx;
}

@Override
public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
 }

// Create new views (invoked by the layout manager)
@Override
public StockCardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                      int viewType) {
    // create a new view
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);

    ViewHolder vh = new ViewHolder(v);
    return vh;
}

// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
    // *ADDED* Send the callback to the bind method
    holder.bindData(mDataset.get(position), mContext, new View.OnClickListener() {
        @Override public void onClick(View v2) {
            final TextView textViewName = (TextView) v2.findViewWithTag("priceTag"); ;
            final String priceTag = textViewName.getText().toString();
        }
    }));
}

// Return the size of your dataset (invoked by the layout manager)
@Override
public int getItemCount() {
    return mDataset.size();
}

}