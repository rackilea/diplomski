ArrayAdapter<Students> arrayAdapter = new ArrayAdapter<Students>(
        this,
        android.R.layout.simple_list_item_single_choice,
        studentList) {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Let the system create and re-use the views
        View view = super.getView(position, convertView, parent);

        // Get the default android layout's TextView
        TextView textView = (TextView) view.findViewById(android.R.id.text1);

        // Get the students info (name or w/e)
        Students student = getItem(position);
        String studentName = student.getName();
        textView.setText(studentName);

        return view;
    }
};