GroceryItemAdapter mAdapter;
public MyViewHolder(View itemView, GroceryItemAdapter adapter) {
    mAdapter = adapter;
    ...
}

// now you can call
mAdapter.delete(getAdapterPosition());