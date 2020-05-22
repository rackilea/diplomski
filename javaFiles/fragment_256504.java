if ("f".equals(noPt_D1) && "".equals(day1_inst) || "".equals(day1_uniform) ||
    "".equals(day1_location))
    {
        Toast.makeText(getApplicationContext(), "Please Enter All Data Or Select the NO PT THIS DAY
        checkbox!", Toast.LENGTH_LONG).show();
    }
    if("t".equals(noPt_D1) || !"".equals(day1_inst) && !"".equals(day1_uniform) &&
    !"".equals(day1_location))
    {
        //PASS VARIABLES WITH INTENT
        Intent intent = new Intent (OneWeekPlan_Start_Btn.this, Week1Day2.class);

        //PASS VARIABLES FOR DAY 1
        intent.putExtra("noPt_D1", noPt_D1);
        intent.putExtra("day1_inst", day1_inst);
        intent.putExtra("day1_uniform", day1_uniform);
        intent.putExtra("day1_location", day1_location);
        intent.putExtra("d1hours", d1hours);
        intent.putExtra("d1min", d1min);
        intent.putExtra("d1x1", d1x1);
        intent.putExtra("d1x2", d1x2);
        intent.putExtra("d1x3", d1x3);
        intent.putExtra("d1x4", d1x4);              
        startActivity(intent);
    }