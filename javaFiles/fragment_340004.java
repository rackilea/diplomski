public float getHighScore(){
    ArrayList<String> text = new ArrayList<String>();

    FileInputStream inputStream;
    try {
        inputStream = (this).openFileInput("highscore");

        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.add(line);
        }
        bufferedReader.close();
    } catch (Exception e) { e.printStackTrace();}
return Float.parseFloat(text.get(1));
}