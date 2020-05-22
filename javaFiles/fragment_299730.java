public class SecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private Context context;
private int count;
private List<Products> productsList;
private List<Category> categories;
private int width;

public SecondAdapter(List<Products> productsList, Context context,int width) {
    this.productsList = productsList;
    this.context = context;
    this.width=width;
}

private class ViewHolder extends RecyclerView.ViewHolder {
    private TextView market_price,our_price,name,unit,min_amount,image;
    private ImageView imagee;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.getLayoutParams().width=width/2;


        market_price=itemView.findViewById(R.id.product_market_price);
        our_price=itemView.findViewById(R.id.product_our_price);
        name=itemView.findViewById(R.id.fruit_name);
        unit=itemView.findViewById(R.id.fruit_unit);
        image=itemView.findViewById(R.id.product_image_url);
        imagee=itemView.findViewById(R.id.iv_rec);
        min_amount=itemView.findViewById(R.id.product_min_amount);

        Log.d("second_adapter","haminjoori");
    }
}

@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view= LayoutInflater.from(context).inflate(R.layout.recycler2_layout,viewGroup,false);
    return new ViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ViewHolder holder= (ViewHolder) viewHolder;
    Helper.logDebug("second_adapter","haminjori");

    holder.name.setText(productsList.get(i).getName());
    holder.unit.setText(productsList.get(i).getUnit());
    holder.market_price.setText(String.valueOf(productsList.get(i).getMarketPrice()));
    holder.our_price.setText(String.valueOf(productsList.get(i).getOurPrice()));
    Helper.logDebug("secondAdapter",productsList.get(i).getImage());
    String address=productsList.get(i).getImage();
    address=address.substring(6);
    holder.image.setText(address);
    String full_address=context.getString(R.string.base_url_image)+address;
    Helper.logDebug("secondAdapter",full_address);
    Picasso.get().load(full_address).into(holder.imagee);
    holder.min_amount.setText(String.valueOf(productsList.get(i).getMin_amount()));
}

@Override
public int getItemCount() {

    Helper.logDebug("second_adapter",String.valueOf(productsList.size()));
    return productsList.size();
}
}