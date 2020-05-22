public class MyVisitorAdapterForRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    public ArrayList<VisitorItem> original;
    public ArrayList<VisitorItem> fitems;
    private Filter filter;
    private Context context;

    public MyVisitorAdapterForRecyclerView(Context context, ArrayList<VisitorItem> items) {
        this.original = new ArrayList<>();
        this.original.addAll(items);
        this.fitems = new ArrayList<>();
        this.fitems.addAll(items);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Otherwise populate normal views
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_normal, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        try {
            MyViewHolder vh = (MyViewHolder) holder;
            vh.bindView(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Similar to getCount function
    @Override
    public int getItemCount() {
        if (fitems == null) return 0;
        else return fitems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // Declare the elements of your row here
        TextView firstName;
        TextView lastName;
        TextView email;
        TextView phoneNumber;
        View dividerView;
        TextView clearButton;

        // Define elements of a row here
        public MyViewHolder(View itemView) {
            super(itemView);

            // Get the view elements here
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            email = itemView.findViewById(R.id.email);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            dividerView = itemView.findViewById(R.id.item_divider);

            clearButton = itemView.findViewById(R.id.item_delete_guest);
        }

        public void bindView(int position) {

            // This is the similar function as getView
            VisitorItem item = fitems.get(position);
            if (item != null) {
                firstName.setText(item.firstName);
                lastName.setText(item.lastName);
                email.setText(item.email);
                phoneNumber.setText(item.phoneNumber);

                if (context instanceof SubmitGuestsActivity)
                    dividerView.setVisibility(View.GONE);
                else dividerView.setVisibility(View.VISIBLE);

                if (context instanceof MyVisitorActivity) {
                    clearButton.setVisibility(View.VISIBLE);
                    clearButton.setOnClickListener(v1 -> new AlertDialog.Builder(getContext(), R.style.myDialogTheme)
                            .setCancelable(true)
                            .setTitle("Confirm delete")
                            .setMessage("Are you sure?")
                            .setPositiveButton("Yes", (dialog, which) -> {
                                VisitorItem itemToBeDeleted = fitems.get(position);
                                VisitorItem.delete(VisitorItem.class, itemToBeDeleted.getId());
                                remove(itemToBeDeleted);
                                fitems.remove(itemToBeDeleted);
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            })
                            .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                            .create().show());
                } else clearButton.setVisibility(View.GONE);

                // Add the click listener here instead of your activity
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, AddVisitorActivity.class);
                        i.putExtra("firstName", fitems.get(position).firstName);
                        i.putExtra("lastName", fitems.get(position).lastName);
                        i.putExtra("email", fitems.get(position).email);
                        i.putExtra("phoneNumber", fitems.get(position).phoneNumber);
                        i.putExtra("position", position);
                        ((MyVisitorActivity) context).startActivityForResult(i, 202);
                    }
                });
            }
        }
    }

    // You do not have to override the add function.
    // However, you can implement one of your own like the one you had earlier.
    public void add(VisitorItem item) {
        this.fitems.add(item);
        this.original.add(item);
        notifyDataSetChanged();
    }

    // You do not have to override the remove function either.
    // However, you can implement one of your own like the one you had earlier.
    public void remove(VisitorItem item) {
        this.fitems.remove(item);
        this.original.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new ItemsFilter();
        }
        return filter;
    }

    private class ItemsFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            String prefix = constraint.toString().toLowerCase();

            if (prefix.length() == 0) {
                ArrayList<VisitorItem> list = new ArrayList<>(original);
                results.values = list;
                results.count = list.size();
            } else {
                final ArrayList<VisitorItem> list = new ArrayList<>(original);
                final ArrayList<VisitorItem> nlist = new ArrayList<>();
                int count = list.size();

                for (int i = 0; i < count; i++) {
                    final VisitorItem item = list.get(i);
                    final String firstName = item.firstName.toLowerCase();
                    final String lastName = item.lastName.toLowerCase();
                    final String email = item.email.toLowerCase();

                    if (firstName.contains(prefix) && lastName.contains(prefix) && email.contains(prefix)) {
                        nlist.add(item);
                    }

                }
                results.values = nlist;
                results.count = nlist.size();
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            fitems = (ArrayList<VisitorItem>) results.values;
            notifyDataSetChanged();
        }
    }
}