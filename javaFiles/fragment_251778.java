public void payments(){
     button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           Intent i = new Intent(getActivity(),MainActivity.class)
           startActivity(i);
           }
        }
   }