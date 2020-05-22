FileOutputStream out;

void clickStart() {
    if (v.getId() == R.id.start){
        // checks which button is clicked
        Log.d("dennis", "Scan working"); //logs the text
        // open a file
        try {
            out = openFileOutput("data.csv", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
}

void writeData() {
    String data= reading1+","+reading2+","+time +"/n";
    try {
        out.write(data.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

void clickStop() {
    if (v.getId() == R.id.stop) {
        try {
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        messageValue.setText(R.string.stopButtonText);// changes the hello world text
            readNoRead=false;
        }
}