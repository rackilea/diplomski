@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if(position == list.size() - 1){
        convertView.setTextColor(Color.rgb(255, 0, 0));
    }
}