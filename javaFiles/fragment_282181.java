public class ToDoAdapter extends ArrayAdapter<ToDoTask> {
    private ArrayList<ToDoTask> objects;
    private Context context;
    private int resource;
    private SparseBooleanArray checkedPositions = new SparseBooleanArray();

    public ToDoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ToDoTask> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ToDoHolder toDoHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row, parent, false);
            toDoHolder = new ToDoHolder();
            toDoHolder.rowTitle = (TextView) convertView.findViewById(R.id.rowTitle);
            toDoHolder.rowDesc = (TextView) convertView.findViewById(R.id.rowDesc);
            toDoHolder.rowDate = (TextView) convertView.findViewById(R.id.rowDate);
            toDoHolder.rowIsDone = (CheckBox) convertView.findViewById(R.id.rowCheckBoxDone);
            convertView.setTag(toDoHolder);
        } else {
            toDoHolder = (ToDoHolder) convertView.getTag();
        }
        toDoHolder.rowTitle.setTag(position);
        toDoHolder.rowIsDone.setTag(convertView);
        toDoHolder.rowIsDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                View view = (View) compoundButton.getTag();
                TextView title = (TextView) view.findViewById(R.id.rowTitle);
                int pos = (int) title.getTag();
                if (checked) {
                    checkedPositions.put(pos, true);
                    view.setBackgroundColor(Color.parseColor("#8FE370"));
                } else {
                    checkedPositions.put(pos, false);
                    view.setBackgroundColor(Color.WHITE);
                }
            }
        });
        ToDoTask object = objects.get(position);
        toDoHolder.rowTitle.setText(object.getTitle());
        toDoHolder.rowDesc.setText(object.getDescription());
        toDoHolder.rowDate.setText(object.getDate());
        toDoHolder.rowIsDone.setChecked(object.getDone() || checkedPositions.get(position));
        return convertView;
    }

    private class ToDoHolder {
        private TextView rowTitle;
        private TextView rowDesc;
        private TextView rowDate;
        private CheckBox rowIsDone;
    }
}