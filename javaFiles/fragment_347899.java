public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

private Context mCtx;
private List<Food> foodList;

public FoodAdapter(Context mCtx, List<Food> foodList) {
    this.mCtx = mCtx;
    this.foodList = foodList;
}

public static class FoodViewHolder extends RecyclerView.FoodViewHolder {
    ImageView imageView;
    TextView txtFoodTitle, txtFoodDesc, txtFoodLoc, txtFoodAuthor;
    //List<Food> foods;
    //Context ctx;

    public FoodViewHolder(View v) {
        super(v);
        imageView = itemView.findViewById(R.id.foodImg);
        txtFoodTitle = itemView.findViewById(R.id.foodTitle);
        txtFoodDesc = itemView.findViewById(R.id.foodDesc);
        txtFoodLoc = itemView.findViewById(R.id.foodLoc);
        txtFoodAuthor = itemView.findViewById(R.id.foodAuthor);
    }
}

@Override
public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(mCtx);
    View view = inflater.inflate(R.layout.list_item, parent, false);
    return FoodViewHolder(view);
}

@Override
public void onBindViewHolder(FoodViewHolder holder, int position) {
    Food food = foodList.get(position);
    holder.txtFoodTitle.setText(food.getFoodTitle());
    holder.txtFoodDesc.setText(food.getFoodDesc());
    holder.txtFoodLoc.setText(food.getFoodLoc() + ", CA");
    holder.txtFoodAuthor.setText(food.getFoodAuthor());
    holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(food.getImage(), null));
}

@Override
public int getItemCount() {
    return foodList.size();
}

}