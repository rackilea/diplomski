public void showCourseDialog(final int i, final int numCourses){
final int index = i;

        //Create a Dialog
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.input_dialog);
        TextView textView = (TextView) dialog.findViewById(R.id.textView4);
        textView.setText("" + i);
        dialog.show();

        //Button for the dialog.
        Button b = (Button) dialog.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get input Course Numbers, numCourses times
                EditText editText = (EditText) dialog.findViewById(R.id.editText2); //EditText
                String getInput = editText.getText().toString();             //String input
                try {
                    courseNumbers[index] = Integer.parseInt(getInput);
                    Toast.makeText(MainActivity.this, "" + courseNumbers[index], Toast.LENGTH_SHORT).show();
                }catch (Exception ex){}

                //Dismiss dialog
                dialog.dismiss();

               if(i < numCourses)
                  showCourseDialog(++i, numCourses);
            }
        });

}