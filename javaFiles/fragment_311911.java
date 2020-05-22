Context c = Main212Activity.getContext();

    SharedPreferences sendnumber = c.getSharedPreferences("name", c.MODE_PRIVATE);
    String Uname = sendnumber.getString("edtTextValue", "");

    int Unameint = Integer.valueOf(Uname);