public class MainListAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<QAnsModel> mainList;

    public MainListAdapter(Context context, ArrayList<QAnsModel> mainList) {
        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public int getCount() {
        return mainList.size();
    }

    @Override
    public Object getItem(int i) {
        return mainList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView questionView;
        TextView answerView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_main_list_layout, null);
            holder = new ViewHolder();
            holder.questionView = (TextView) convertView.findViewById(R.id.itemQuestion);
            holder.answerView = (TextView) convertView.findViewById(R.id.itemAnswer);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        QAnsModel model = (QAnsModel) getItem(position);

        holder.questionView.setText(model.getQuestion());
        holder.answerView.setText(model.getAnswer());

        return convertView;
    }
}