public View getView(int position, View convertView, ViewGroup parent) {
        switch (position) {
        case 0:         
            // do image switch option
            // convertView = layout 0
            break;
        case 3:
            // do button whatever option
            // convertView = layout 3
            break;
        case 5:
            // do button whatever option
            // convertView = layout 5
            break;
        default:
            // do normal option
            // convertView = layout 1
            break;
        }
        return convertView;
    }