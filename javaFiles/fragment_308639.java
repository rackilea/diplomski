public class BookAdapter extends BaseAdapter {

    private Context context;
    private List<BookModel> books;

    static class Holder{
        TextView mTvName;
    }

    public BookAdapter(Context context, List<BookModel> books){
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);

            holder = new Holder();

            holder.mTvName = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        final BookModel bookModel = books.get(position);

        if(bookModel != null){

            holder.mTvName.setText(bookModel.name);

            if(bookModel.isRead){
                holder.mTvName.animate().alpha(0.2f);
                bookModel.isRead = true;
            }else{
                holder.mTvName.animate().alpha(1f);
                bookModel.isRead = false;
            }
        }

        return convertView;
    }
}