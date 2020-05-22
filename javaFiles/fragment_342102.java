public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   String[] mDataset = { "Data" };

   @Override
   public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout, parent, false);

       MyAdapter.ViewHolder vh = new ViewHolder(v, new MyAdapter.ViewHolder.IMyViewHolderClicks() { 
           public void onPotato(View caller) { Log.d("VEGETABLES", "Poh-tah-tos"); };
           public void onTomato(ImageView callerImage) { Log.d("VEGETABLES", "To-m8-tohs"); }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager) 
    @Override 
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get element from your dataset at this position 
        // Replace the contents of the view with that element 
        // Clear the ones that won't be used
        holder.txtViewTitle.setText(mDataset[position]);
    } 

    // Return the size of your dataset (invoked by the layout manager) 
    @Override 
    public int getItemCount() { 
        return mDataset.length;
    } 
  ...