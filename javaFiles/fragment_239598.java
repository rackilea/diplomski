public View getView(int position, View convertView, ViewGroup parent) {
    if(convertView == null) {
        inflate the view
        create a ViewHolder and store the necessary views in it
        use setTag to store the ViewHolder in the convertView
    }
    else {
        use getTag to get the ViewHolder
    }
    update the views // <- you are not doing this when convertView != null
}