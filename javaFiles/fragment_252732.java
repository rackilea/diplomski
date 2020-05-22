@Override
protected Integer doInBackground(Void... params) {
    if(MainActivity.playing) {
        int percent;
        int position = MainActivity.Player.getCurrentPosition();
        int timeRunning = MainActivity.Player.getDuration();
        if (timeRunning == 0 || position == 0) {
            percent = 0;
        } else {
            percent = (position * 100) / timeRunning;
        }

        return percent;
    }
    return -1;
}
@Override
protected void onPostExecute(Integer result) {
    if(result  != -1){
    MainActivity.Mbar.setProgress(result);}

}