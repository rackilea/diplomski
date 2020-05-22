@Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        try{   
    String etName =  ETName.getText().toString();
if(!etName.trim().equals("")){
                            File file =new File("/sdcard/Accelerometer.html");

                            //if file doesnt exists, then create it
                            if(!file.exists()){
                                file.createNewFile();
                            }


                            FileWriter fileWritter = new FileWriter(file.getName(),true);
                                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                                bufferWritter.write(etName);
                                bufferWritter.close();
                } 
                        }catch (IOException e) {

                            e.printStackTrace(); }


                    }