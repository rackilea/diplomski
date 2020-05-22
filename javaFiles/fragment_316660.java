public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<MyModel> mData;

    public MyRecyclerViewAdapter(@NonNull List<MyModel> data) {
        mData = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MyModel.ModelTypes type = MyModel.ModelTypes.values()[viewType];
        return MyHolder.inflateViewByType(type, layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        MyModel model = mData.get(position);
        switch (model.type) {
            case TYPE_1:
                setupViewType1((MyHolderType1) holder, model);
                break;
            case TYPE_2:
                setupViewType2((MyHolderType2) holder, model);
                break;
        }
    }

    // to update the adapter data without reinitialize it
    public void updateData(@NonNull List<MyModel> newData) {
        mData = newData;
        notifyDataSetChanged();
    }

    private void setupViewType1(MyHolderType1 holder, MyModel model) {

        // do what you want with your views in layout_type_1
    }

    private void setupViewType2(MyHolderType2 holder, MyModel model) {

        // do what you want with your views in layout_type_2
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type.ordinal();
    }
}