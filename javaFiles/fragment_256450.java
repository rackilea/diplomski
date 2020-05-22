buttonBackspace.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
           String word = editText.getText().toString();               
           int input = word.length();
              if (input > 0){
                 editText.setText(word.substring(0, input-1));
              }          
           }
});