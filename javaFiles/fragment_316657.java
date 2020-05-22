public class MyHolder extends RecyclerView.ViewHolder {

    // must have the ViewHolder default constructor
    public MyHolder(View itemView) {
        super(itemView);
    }

    public static MyHolder inflateViewByType(MyModel.ModelTypes type, 
                                            LayoutInflater layoutInflater, ViewGroup parent) {
        View view;
        switch (type) {
            case TYPE_1:
                view = layoutInflater.inflate(R.layout.layout_type_1, parent, false);
                return new MyHolderType1(view);
            break;
            case TYPE_2:
                view = layoutInflater.inflate(R.layout.layout_type_2, parent, false);
                return new MyHolderType2(view);
            break;
        }
        // Model type not supported
        return null;
    }
}