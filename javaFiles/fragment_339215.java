public class DrivesRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    @Override
    public int getItemViewType(int position) {
        return flag ? 0 : 1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drive, parent, false);

        if (viewType == 1) {
            return new DriveViewHolder1(view);
        } else {
            return new DriveViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drive drive = drives.get(position);
        int viewType = getItemViewType(position);

        if (viewType == 1) {
            DriveViewHolder1 vaultItemHolder1 = (DriveViewHolder1) holder;
            vaultItemHolder1.nameTextView.setText(drive.getName());
            vaultItemHolder1.phoneTextView.setText(drive.getStartAddress());//the change
        } else {
            DriveViewHolder2 vaultItemHolder2 = (DriveViewHolder2) holder;
            vaultItemHolder2.nameTextView.setText(drive.getName());
            vaultItemHolder2.phoneTextView.setText(drive.getEmail());//the change
        }
    }

    ...
}