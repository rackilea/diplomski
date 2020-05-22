public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button1:
            //do button1 action

            // start next activity here
            Intent intent=new Intent(menu.this,Job.class);
            startActivity(intent);
            break;
         ///.... same for all buttons 

        }
   }