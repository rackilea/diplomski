View view = inflateSetup.inflate(R.layout.inflate_setup;
final EditText edtPassword3 = (EditText)viewInflate_setup.findViewById(R.id.edtPassword3);
alertSetup.setView(view, null));
  alertSetup.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override 
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("User has clicked the [confirm] button");
                SUpassword3 = edtPassword3.getText().toString(); 
 ....