public View getView(int position, View convertView, ViewGroup parent) {
    convertView = super.getView(position, convertView, parent);

    if(!isEnabled(position)) { 
        /* change to disabled appearance */ 
    } 
    else { 
        /* restore default appearance */ 
    }
    return convertView;
}