fb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         //data6 may be having link to fb ,here we check if it is not null 
           if(data6!=null )
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data6));
            startActivity(intent);
        }else{
         //toast a message
          Toast.makeText(Yourclass.this, "Sorry there's no link available at this moment", Toast.LENGTH_SHORT).show();
         }
    });