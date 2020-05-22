// i have edit your adapter class

public class ServerApater extends RecyclerView.Adapter<ServerApater.OriginalViewHolder> {

private List<CommonModels> items = new ArrayList<>();
private Context ctx;
private View.OnClickListener onClickListener;


public ServerApater(Context context, List<CommonModels> items,View.OnClickListener onClickListener) {
    this.items = items;
    ctx = context;
    this.onClickListener=onClickListener;
}


@Override
public ServerApater.OriginalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ServerApater.OriginalViewHolder vh;
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_server, parent, false);
    v.findViewById(R.id.card_view_home).setOnClickListener(onClickListener);

    vh = new ServerApater.OriginalViewHolder(v);
    return vh;
}

@Override
public void onBindViewHolder(final ServerApater.OriginalViewHolder holder, final int position) {

    CommonModels obj = items.get(position);
    holder.name.setText(obj.getTitle());



    if (position==0){
        viewHolder=holder;
        new DetailsActivity().iniMoviePlayer(obj.getStremURL(),obj.getServerType(),ctx);
        holder.name.setTextColor(ctx.getResources().getColor(R.color.colorPrimary));
    }

    holder.cardView.setTag(obj);

}

@Override
public int getItemCount() {
    return items.size();
}

public class OriginalViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public CardView cardView;

    public OriginalViewHolder(View v) {
        super(v);
        name = v.findViewById(R.id.name);
        cardView=v.findViewById(R.id.card_view_home);
    }
}

public void chanColor(ServerApater.OriginalViewHolder holder,int pos){

    if (pos!=0){
        viewHolder.name.setTextColor(ctx.getResources().getColor(R.color.grey_60));
    }

    if (holder!=null){
        holder.name.setTextColor(ctx.getResources().getColor(R.color.grey_60));
    }
 }

}


// call Adapter from activity like this
 ServerApater serverApater=new ServerApater(this,"pass here commonModel type 
 list",this);


// implement View.OnClickListener with Activity like this
 AppActivity extends AppCompatActivity implements View.OnClickListener


// then implement onclick() method
@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.card_view_home:
            CommonModels obj = (CommonModels) v.getTag();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(obj.getStremURL()), "video/*");
            startActivity(Intent.createChooser(intent, "Complete action using"));
            break;
    }
}