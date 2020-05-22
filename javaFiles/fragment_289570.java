@Override
public View getView(int position, View convertView, ViewGroup parent) {
if (convertView == null) {
    convertView = mInflater.inflate(R.layout.year_row, parent, false);
}

TextView name = (TextView) convertView.findViewById(R.id.year_name);
Graph graph = (Graph) convertView.findViewById(R.id.year_graph);
TextView average = (TextView) convertView.findViewById(R.id.year_average);
TextView progress = (TextView) convertView.findViewById(R.id.year_progress);

    ArrayList<Object> row = list.get(position);

    name.setText(String.valueOf(row.get(0)));
    graph = (Graph)row.get(1);
    average.setText(String.valueOf(row.get(2)));
    progress.setText(String.valueOf(row.get(3)));

    return convertView;
}