public class ShippingAdapter extends RecyclerView.Adapter<ShippingAdapter.ViewHolder> {

    private ArrayList<ShippingOptions> list;
    private int expandedPosition = -1;
    private int listSize = 0;
    private int checkedPositon = -1;
    private String currency;

    public ShippingAdapter(ArrayList<ShippingOptions> list, String currency, AdapterInterface listener) {
        this.list = list;
        listSize = list.size();
        this.currency = currency;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_shipping_options, parent, false);
        // Layout in which you will add **android:animatelayoutchanges**
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ShippingOptions item = list.get(position);
        holder.name.setText(item.getName());
        holder.fee.setText(utils.getFormattedCurrency(currency, Double.parseDouble(item.getShippingFee())));
        holder.description.setText(item.getDescription());
        holder.deliveryTime.setText(item.getDeliveryTime());
        if (listSize == 1) {
            list.get(position).setExpanded(true);
        }


        **if (list.get(position).isExpanded()) {
            holder.expandableView.setVisibility(View.VISIBLE);
            holder.checkBox.setVisibility(View.VISIBLE);
            if (checkedPositon == position) {
                holder.checkBox.setChecked(true);
            } else {
                holder.checkBox.setChecked(false);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.parent.setElevation(12);
                holder.parent.setTranslationZ(6);
                holder.parent.setClipToPadding(false);
                holder.parent.setClipToOutline(false);
            }
        } else {
            holder.expandableView.setVisibility(View.GONE);
            holder.checkBox.setVisibility(View.GONE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.parent.setElevation(0);
                holder.parent.setTranslationZ(0);
            }
        }**

        **holder.parent.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                if (listSize > 1) {
                    if (expandedPosition == position) {
                        if (list.get(position).isExpanded()) {
                            list.get(position).setExpanded(false);
                        } else {
                            list.get(position).setExpanded(true);
                        }
                        notifyItemChanged(position);
                    } else {
                        if (expandedPosition >= 0) {
                            list.get(expandedPosition).setExpanded(false);
                            notifyItemChanged(expandedPosition);
                        }
                        expandedPosition = position;
                        list.get(expandedPosition).setExpanded(true);
                        notifyItemChanged(expandedPosition);
                    }
                }
            }
        });**


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name, fee, description, deliveryTime;
        public LinearLayout parent, expandableView;
        public CheckBox checkBox;

        public ViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.tv_shipping_name);
            fee = (TextView) v.findViewById(R.id.tv_shipping_fee);
            description = (TextView) v.findViewById(R.id.tv_description);
            deliveryTime = (TextView) v.findViewById(R.id.tv_delivery_time);
            parent = (LinearLayout) v.findViewById(R.id.parent);
            expandableView = (LinearLayout) v.findViewById(R.id.expandable_view);
            checkBox = (CheckBox) v.findViewById(R.id.checkbox);

        }


    }
}