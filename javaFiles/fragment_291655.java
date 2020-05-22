public void viewAll() {
    Cursor res = myDb.getAllData();
    if (res.getCount() == 0) {
        // show error
        System.out.println("No Data Found");
        return;
    }
    StringBuilder idsb = new StringBuilder();
    StringBuilder namesb = new StringBuilder();
    StringBuilder descsb = new StringBuilder();
    StringBuilder locsb = new StringBuilder();
    String endofline = "";

   TextView textViewID = (TextView) findViewById(R.id.textViewID);
   TextView textViewName = (TextView) findViewById(R.id.textViewName);
   TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
   TextView textViewLocation = (TextView) findViewById(R.id.textViewLocation);


    while (res.moveToNext()) {
        System.out.println("Id: " + res.getString(0) + "\n");
        System.out.println("Title: " + res.getString(1) + "\n");
        System.out.println("Description: " + res.getString(2) + "\n");
        System.out.println("Location: " + res.getString(4) + "\n\n");
        idsb.append("Id: ").append(res.getString(0)).append(endofline);
        namesb.append("Name: ").append(res.getString(1)).append(endofline);
        descsb.append("Description: ").append(res.getString(2)).append(endofline);
        locsb.append("Location: ").append(res.getString(4)).append(endofline);
        if (endofline.length() == 0) {
            endofline = "\n";
        }
    }
    textViewId.setText(idsb.toString());
    textViewName.setText(namesb.toString());
    textViewDescription.setText(descsb.toString());
    textViewLocation.setText(locsb.toString());
}