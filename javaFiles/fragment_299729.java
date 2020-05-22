public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private Context context;
private List<Category> categories;
private List<Ads> ads_list;
private List<Products> productsList;
private int count;
private int width;

public MainAdapter(Context context, List<Category> categories, List<Ads> ads_list,List<Products> productsList,int width) {
    this.context = context;
    this.categories = categories;
    this.ads_list = ads_list;
    this.productsList=productsList;
    this.width=width;
    //Helper.logDebug("main__adapter",String.valueOf(categories.size()));
    //Helper.logDebug("main_adapter","haminjoori");
}

private class ViewHolder extends RecyclerView.ViewHolder{
    private RecyclerView recyclerView;
    private TextView tv_type,ad_tv_image_address;
    private ImageView iv_ad;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        recyclerView=itemView.findViewById(R.id.recyclerview_horizental);
        recyclerView.setNestedScrollingEnabled(false);
        tv_type=itemView.findViewById(R.id.tv_type);
        iv_ad=itemView.findViewById(R.id.iv_ad);
        ad_tv_image_address=itemView.findViewById(R.id.ad_image_address);
        //Helper.logDebug("main_adapter","haminjoori");
    }
}

@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view= LayoutInflater.from(context).inflate(R.layout.recycler_layout,viewGroup,false);
    //Helper.logDebug("main_adapter","haminjoori");
    return new ViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ViewHolder holder= (ViewHolder) viewHolder;
    try {
        String banner_url=ads_list.get(i).getImage();
        holder.ad_tv_image_address.setText(banner_url);
        Picasso.get().load(context.getString(R.string.base_url_banner)+banner_url).into(holder.iv_ad);
    }catch (Exception ex){
        holder.ad_tv_image_address.setText("");
    }
    Helper.logDebug("main_adapter",holder.ad_tv_image_address.getText().toString());
    holder.tv_type.setText(categories.get(i).getName());
    SecondAdapter secondAdapter=new SecondAdapter(categories.get(i).getProducts(),context,width);
    LinearLayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);

    holder.recyclerView.setLayoutManager(layoutManager);
    holder.recyclerView.setAdapter(secondAdapter);



}

@Override
public int getItemCount() {
    return categories.size();
}
}