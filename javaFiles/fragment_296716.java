public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements View.OnClickListener {

private Context context;
private List<MyData> my_data;

public CustomAdapter(Context context, List<MyData> my_data) {
    this.context = context;
    this.my_data = my_data;
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

    return new ViewHolder(itemView);
}

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.match_date.setText(my_data.get(position).getMatch_date());
        holder.home_name.setText(my_data.get(position).getHome_name());
        holder.away_name.setText(my_data.get(position).getAway_name());

        holder.button.setId(my_data.get(position).getId());
        holder.button.setTag(my_data.get(position).getStringId());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intHomeGoals = Integer.parseInt(holder.edtHomeGoals.getText().toString());
                int intAwayGoals = Integer.parseInt(holder.edtAwayGoals.getText().toString());
                if (intHomeGoals == intAwayGoals)
                {
                    Toast.makeText(context, "00000", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Glide.with(context).load(my_data.get(position).getHome_logo()).into(holder.home_logo);
        Glide.with(context).load(my_data.get(position).getAway_logo()).into(holder.away_logo);
}