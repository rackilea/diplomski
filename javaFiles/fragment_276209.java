@Override
public View getView(final int position, final View convertView, ViewGroup parent) {
    if(convertView == null) {
        //Inflate your view here
    }
    if(position % 2 != 1) {
        //Only need to change background if we're odd, since it's red by default
        convertView.setBackgroundColor(Color.BLUE);
    }
}