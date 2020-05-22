private class Task extends AsyncTask<URL, Integer, Long> {
    private Int type;
    private Object[] objects;
    public Task(Int type, Object[] objects) {
        this.type = type;
        this.objects = objects;
    }
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
        }
        //obviously you can switch on whatever string/int you'd like
        switch (type) {
            case 0:  taskFile();
                     break;
            case 1:  taskInteger();
                     break;
            case 2:  taskString();
                     break;
            default: break;
        }
        return totalSize;
    }

    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
    protected void taskFile(){ //do something with objects array }
    protected void taskInteger(){ //do something with objects array }
    protected void taskString(){ //do something with objects array }
}