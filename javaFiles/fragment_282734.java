builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
          name = input_field.getText().toString().trim();

          if(name.isEmpty()){
             name = default_name;
          }

          ...

          intent.putExtra("user_name", name);

          ... 
    }
});