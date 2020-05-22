@Override
    public void onClick(View view) {
        if (view==LoginBtn){
 startActivity(new Intent(this,Login1.class));
        }else if(view==Capture){
startActivity(new Intent(this,Capture.class));

      }
     //Do rest by yourself.

    }