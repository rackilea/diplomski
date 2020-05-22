public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
    View listItem = convertView;
    if(listItem == null)
        listItem = LayoutInflater.from(sContext).inflate(R.layout.item_tasks, parent,false);

    try {
        final Tasks presenteTask = taskData.get(position);
        TextView taskTitle = (TextView) listItem.findViewById(R.id.tasksTitle);
        taskTitle.setText(presenteTask.getTitle());
        EditText taskColor = (EditText) listItem.findViewById(R.id.taskColor);
        taskColor.setBackgroundColor(Color.parseColor(presenteTask.getHexaColor()));
    } catch(Exception ex) {
        Log.v(TasksAdapter.class.getSimpleName(), "Exception at: " + position);
    }

    return listItem;
}