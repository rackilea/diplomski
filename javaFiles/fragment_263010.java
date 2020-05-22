private class YourTasksClass extends AsyncTask<Void, Void, String> {


    private String cmd;

    public YourTasksClass(String command) {
        this.cmd = command;
    }

    @Override
    protected String doInBackground(Void... voids) {


        try {
            Process process = Runtime.getRuntime().exec(cmd);

            // ....

            String someResult = "some kind of result";

            return someResult;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if(result != null) {
            Log.d("tag", "Result: " + result);
        }

    }
}