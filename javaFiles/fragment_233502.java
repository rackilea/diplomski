//From activity A
Intent iin = getIntent();
Bundle b = iin.getExtras();

//From Activity C
Intent i2 = getIntent();
Bundle abcd = i2.getExtras();

if(b != null){
    String j = "String to check"; // Replace content inside "" with your string 
    Toast.makeText(getApplicationContext(), j, Toast.LENGTH_LONG).show();
    if(j.equals(b.getString("arrowvisi"))){
        img_back.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), "Operational arrow visible", Toast.LENGTH_LONG).show();
    }else{
        if(abcd != null){
            String jst = "String to check"; // Replace with string you want to check
            if(jst.equals(abcd.getString("arrow_val"))){
                img_back.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "scan dispatch visble", Toast.LENGTH_LONG).show();
                }else{
                    //img_back.setVisibility(View.GONE);
                    System.out.println("from scan dispatch");
                    Toast.makeText(getApplicationContext(), "scan dispatch not visible", Toast.LENGTH_LONG).show();
                }
            }
            Toast.makeText(getApplicationContext(), "Operational not visible", Toast.LENGTH_LONG).show();
        }
    }