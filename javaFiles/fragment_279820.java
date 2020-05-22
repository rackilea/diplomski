if(r1 == 1){
         Intent q1 = new Intent(this,Quiz_2.class);
         Bundle bundle1 = new Bundle();
         bundle1.putString("passVisit", visited);
         q1.putExtras(bundle1);
         q1.putExtra("passScore", score);
         startActivity(q1);
         finish();
     }

     else if(r1 == 2){
         Intent q1 = new Intent(this,Quiz_3.class);
         Bundle bundle1 = new Bundle();
         bundle1.putString("passVisit", visited);
         q1.putExtras(bundle1);
         q1.putExtra("passScore", score);
         startActivity(q1);
          finish();
     }

     else if(r1 == 3){
         Intent q1 = new Intent(this,Quiz_4.class);
         Bundle bundle1 = new Bundle();
         bundle1.putString("passVisit", visited); // visited = 1 ...> string value
         q1.putExtras(bundle1);
         q1.putExtra("passScore", score);
         startActivity(q1);
          finish();
     }

     else if(r1 == 4){
         Intent q1 = new Intent(this,Quiz_5.class);
         Bundle bundle1 = new Bundle();
         bundle1.putString("passVisit", visited);
         q1.putExtras(bundle1);
         q1.putExtra("passScore", score);
         startActivity(q1);
          finish();
     }