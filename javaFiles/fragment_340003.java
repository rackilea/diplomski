public void setHighScore(float highscore){
    FileOutputStream outputStream = null;
    try {
        outputStream = (this).openFileOutput("highscore", Context.MODE_PRIVATE);

        outputStream.write(Float.toString(f)).getBytes());
        outputStream.close();

    } catch (Exception e) {e.printStackTrace();}
}