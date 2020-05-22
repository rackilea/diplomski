public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private String[] mDataset;

public MyAdapter(String[] myDataset) {
    mDataset = myDataset;
}

class ViewHolder0 extends RecyclerView.ViewHolder {
    ...
    public ViewHolder0(View itemView){
        // Set default flag as background
    ...
    }
}

class ViewHolder1 extends RecyclerView.ViewHolder {
    ...
    public ViewHolder1(View itemView){
        // Inflate your gridview layout here
        ...
    }
    // define methods to interact with your grid view
}

class ViewHolder2 extends RecyclerView.ViewHolder {
    ...
    public ViewHolder2(View itemView){
        // Set Sri Lankan flag as background
    ...
}

@Override
public int getItemViewType(int position) {
    // determine your desired viewType here from dataset for example        
    switch (mDataset[position]){
        case "Identifier":// your logic to identify for displaying gridview
            return 1;
        case "Sri Lanka":
            return 2;
        case "Australia":
            return 3;
        default:
            return 0;
    }
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     switch (viewType) {
         case 0: return new ViewHolder0(...);
         case 1: return new ViewHolder1(...);//holder responsible for you grid view
         case 2: return new ViewHolder2(...);
         ...
     }
}

@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    switch (holder.getItemViewType()) {
        case 0:
            ViewHolder0 viewHolder0 = (ViewHolder0)holder;
            ...
            break;

        case 1:
            ViewHolder1 viewHolder1 = (ViewHolder1)holder;
            // here, bind data to your grid view
            ...
            break;

        case 2:
            ViewHolder2 viewHolder2 = (ViewHolder2)holder;
            ...
            break;
    }
}
}