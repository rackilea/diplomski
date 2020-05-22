Calendar c1 =  Calendar.getInstance();
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

    Date lowerBound = sdf1.parse("20-10-2013");
    Date upperBound = sdf1.parse("30-12-2013");

    TextView txtdate1 = (TextView) findViewById(R.id.textView1);

    if (c1.getTime().before(upperBound) && c1.getTime().after(lowerBound)) {
        txtdate1.setText("Is up to date");
    } else {
        txtdate1.setText("Is not up to date");
    }