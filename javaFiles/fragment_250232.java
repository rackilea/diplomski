for(int i = 0; i < nbdrone; i++) {
    final View rowView = inflater.inflate(R.layout.dronelayoutmain, null);
    textViewnomConstructeurDrone = rowView.findViewById(R.id.textViewNomConstructeur);
    string = droneprefs.getString(String.valueOf(i),"Fail");
    textViewnomConstructeurDrone.setText(string);
    mlineairelayout.addView(rowView);
}