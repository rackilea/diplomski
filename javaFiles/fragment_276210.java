@Override
public View getView(final int position, final View convertView, ViewGroup parent) {
    if(convertView == null) {
        //Inflate your view here
    }
    if(position % 2 != 1) {
        convertView.setBackgroundColor(Color.BLUE);
    } else {
        //Set the background no matter what so we make sure our view reflects our data
        convertView.setBackgroundColor(Color.RED);
    }
}