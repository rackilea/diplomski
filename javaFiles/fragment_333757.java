AlertDialog.Builder builder = new AlertDialog.Builder(SimpleVideoStream.this);
LayoutInflater inflater = this.getLayoutInflater();
View dialogView= inflater.inflate(R.layout.custom_alertdialog, null); 
builder.setView(inflater.inflate(R.layout.custom_alertdialog, null))
final EditText editText = (EditText)dialogView.findViewById(R.id.url); 

builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                     //Do something
                    }
                }
            });
       .setNegativeButton(){
                   //Do something
       };
builder.create();
builder.show();