public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {

    Context context;

    public RVAdapter(Context context,...){

        this.context = context
    }
}


RVAdapter adapter = new RVAdapter(this,events);