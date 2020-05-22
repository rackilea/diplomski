@Override
public View getView(int position, View convertView, ViewGroup parent) {

    // .. inflate View

    Spot s = (Spot) getItem(position);

    // .. use fields from Spot that are common to fill list view item

    // add info specific to restaurants
    if (s instanceof Restaurant) {
        // fill in extra contact info:
        contactView.setText(((Restauarant) s).contact);
    }

    return v;

}