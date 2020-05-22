public void verificaNumar (){
            String cautare = editCauta.getText().toString();
            if(myDb.cautaNumar(cautare)) {
                Toast.makeText(MainActivity.this, "employee exist", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(MainActivity.this,"employee not found", Toast.LENGTH_LONG).show();
            }
        }