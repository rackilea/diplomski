private Context context;
private List<Currency> currency;
private Activity activity;


public AdapterChat(Context context, List<Currency> currency) {
    this.context = context;
    this.currency = currency;
    activity = (Activity) context;
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    AdapterChat.ViewHolder vh;
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_currency, parent, false);
    vh = new AdapterChat.ViewHolder(itemView);
    return vh;
}

@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.txt_currency_name.setText(currency.get(position).getName());
    holder.txt_currency_name.setText(currency.get(position).getValue);
}



@Override
public int getItemCount() {
    return chat.size();
}

public  class ViewHolder extends  RecyclerView.ViewHolder{

    public TextView txt_currency_name;
    public TextView txt_currency_value;



    public ViewHolder(View itemView) {
        super(itemView);
        txt_currency_name = (TextView) itemView.findViewById(R.id.txt_currency_name);
        txt_currency_name = (TextView) itemView.findViewById(R.id.txt_currency_name);
    }
}