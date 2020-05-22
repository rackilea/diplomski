@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    RecyclerView.ViewHolder holder = null;
    if(viewType == View_Item) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_match, parent, false);
        holder = new ViewHolder_Item(view);

    }else if(viewType == View_Header) {
         // inflate header layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.header_layout, parent, false);
        holder = new ViewHolder_header(view);

    }
 return holder;
 }