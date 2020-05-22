final CharSequence[] items = {"","50","100","150","200","250","300","350","400","450","500","550","600","650","700","750","800","850","900","1000"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        builder.setTitle("Select Country");
        //builder.setI
        builder.setItems(items, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int item) {
                //Toast.makeText(getApplicationContext(), con.get(item).getCountrName(), Toast.LENGTH_SHORT).show();
                selectDistanceTV.setText(items[item]);
                System.out.println("Item is: "+items[item]);
                /*CONTRY_ID = con.get(item).getCountryId();
                stateET.requestFocus();*/
           }
        });
        AlertDialog alert = builder.create();
        alert.show();