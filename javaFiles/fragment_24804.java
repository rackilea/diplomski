ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinaca, items) {

     public View getView(int position, View convertView, ViewGroup parent) {
             View v = super.getView(position, convertView, parent);

             Typeface externalFont=Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTCom-Lt.ttf");
             ((TextView) v).setTypeface(externalFont);

             return v;
     }


     public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
              View v =super.getDropDownView(position, convertView, parent);

             Typeface externalFont=Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTCom-Lt.ttf");
             ((TextView) v).setTypeface(externalFont);

             return v;
     }
};