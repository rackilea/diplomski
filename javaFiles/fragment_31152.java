String text = editText.getText().toString();
           boolean checked = radioButton.isChecked();
           // do what you want with these
           FileOutputStream outputStream;
           try{
                outputStream = openFileOutput(fileName,CONTEXT.MODE_PRIVATE);
                outputStream.write(text.getBytes());
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }