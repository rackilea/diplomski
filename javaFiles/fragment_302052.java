rowView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //Toast.makeText(context, "You Clicked "+result[position], 2000).show();

             AlertDialog.Builder builder = new AlertDialog.Builder(context);
             builder.setTitle("Title");

             builder.setMessage("Message");
             builder.setPositiveButton("OK",
                     new DialogInterface.OnClickListener()
                     {

                         public void onClick(DialogInterface dialog, int id)
                         {
                             dialog.cancel();
                              Intent intent = new Intent(context, Activity2.class);
                              context.startActivity(intent);
                         }
                     });
             AlertDialog alert = builder.create();
             alert.show();

        }
        });