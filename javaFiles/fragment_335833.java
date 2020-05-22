ParseQuery query = new ParseQuery<>("Plants2");
query.whereEqualTo("plantName", (name));
query.findInBackground(new FindCallback<ParseObject>() {
public void done(List<ParseObject> listCountry, ParseException e) {
   for (ParseObject country : listCountry) {
            // Locate images in flag column
            ParseFile image = (ParseFile) country.get("image");

            //PlantListitems map = new PlantListitems();
            txtKGsays.setText((String) country.get("KGsays"));
            txtCare.setText((String) country.get("Care"));
            txtTips.setText((String) country.get("tips"));
            //imgflag.DisplayImage(image.getUrl());
            //plantlist.add(map);
        }
}
});