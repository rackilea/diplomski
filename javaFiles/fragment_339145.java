Bundle b = getIntent().getExtras();
    int index = b.getInt("index");

    if(index == 1){
        //s1 spinner
        //example: show spinner1
        //spinner1.setVisibility(View.VISIBLE);
        //spinner2.setVisibility(View.GONE);        
    }else{
        //s2 spinner
        //example: show spinner2
        //spinner1.setVisibility(View.GONE);
        //spinner2.setVisibility(View.VISIBLE);
    }