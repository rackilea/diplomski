public MyDialog(Context context){
    super(context);

    setContentView(R.layout.dialog_layout);
    setTitle("Add new student");

    buttonAddStudent= (Button) findViewById(R.id.buttonAdd);    
    buttonCancel= (Button) findViewById(R.id.buttonCancel);
    etName= (EditText) findViewById(R.id.editTextName);
    etAge= (EditText) findViewById(R.id.editTextAge);

    buttonAddStudent.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String name= etName.getText().toString();
            int age= Integer.valueOf(etAge.getText().toString());

            Student sv= new Student(name, age);
            MainActivity.listStudent.add(sv);

            //Toast.makeText(getContext(), MainActivity.listStudent.toString(), Toast.LENGTH_SHORT).show();

        }
    });

}