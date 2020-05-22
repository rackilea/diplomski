int[] ids = {R.id.spinner_grade_1,R.id.spinner_grade_2};
        Spinner[] spinners = new Spinner[ids.length];


    for(int i=0 ;i< ids.length;i++) {
               spinners[i] = (Spinner) findViewById(ids[i]);
            }