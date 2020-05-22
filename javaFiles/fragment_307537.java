expListView.setOnChildClickListener(new OnChildClickListener() {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                int groupPosition, int childPosition, long id) {

            switch(groupPosition) {
             case 1:
                switch (childPosition) {
                case 0: 
                    Intent c1= new Intent(MainActivity.this,Webv1Activity.class);
                    startActivity(c1);
                    break;

                }

=======>>>>>    break;

             case 2:
                switch (childPosition) {
                case 0: 
                    Intent d1= new Intent(MainActivity.this,Webv1Activity.class);
                    startActivity(d1);
                    break;
                case 1: 
                    Intent d2= new Intent(MainActivity.this,Webv2Activity.class);
                    startActivity(d2);
                    break;
                case 2: 
                    Intent d3= new Intent(MainActivity.this,Webv3Activity.class);
                    startActivity(d3);
                    break;
                case 3: 
                    Intent d4= new Intent(MainActivity.this,Webv4Activity.class);
                    startActivity(d4);
                    break;
                case 4: 
                    Intent d5= new Intent(MainActivity.this,Webv5Activity.class);
                    startActivity(d5);
                    break;
                case 5: 
                    Intent d6= new Intent(MainActivity.this,Webv6Activity.class);
                    startActivity(d6);
                    break;
                case 6: 
                    Intent d7= new Intent(MainActivity.this,Webv7Activity.class);
                    startActivity(d7);
                    break;
                case 7: 
                    Intent d8= new Intent(MainActivity.this,Webv8Activity.class);
                    startActivity(d8);
                    break;


                }

==========>>>>> break;               

            case 3:
                switch (childPosition) {
                case 0: 
                    Intent a1= new Intent(MainActivity.this,Webv9Activity.class);
                    startActivity(a1);
                break;
                case 1: 
                    Intent a2= new Intent(MainActivity.this,Webv10Activity.class);
                    startActivity(a2);
                    break;
                case 2: 
                    Intent a3= new Intent(MainActivity.this,Webv11Activity.class);
                    startActivity(a3);
                    break;
                case 3: 
                    Intent a4= new Intent(MainActivity.this,Webv12Activity.class);
                    startActivity(a4);
                    break;
                case 4: 
                    Intent a5= new Intent(MainActivity.this,Webv13Activity.class);
                    startActivity(a5);
                    break;
                case 5: 
                    Intent a6= new Intent(MainActivity.this,Webv14Activity.class);
                    startActivity(a6);
                    break;
                case 6: 
                    Intent a7= new Intent(MainActivity.this,Webv15Activity.class);
                    startActivity(a7);
                    break;
                case 7: 
                    Intent a8= new Intent(MainActivity.this,Webv16Activity.class);
                    startActivity(a8);
                    break;


                }
            }
            return false;
        }
        });