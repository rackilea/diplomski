private class YourUpdateTask extends AsyncTask<Integer, Void, Integer> {
        /**
         * The system calls this to perform work in a worker thread and delivers
         * it the parameters given to AsyncTask.execute()
         */
        protected Integer doInBackground(Integer... millis) {
            try {
                int waited = 0;
                int duration = yourTimeHere;
                while (waited < duration) {
                    Thread.sleep(100);
                    waited += 100;
                }
            } catch (InterruptedException e) {
                // do nothing
            }

            updateState();

            return 1;
        }

        /**
         * The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground()
         */
        protected void onPostExecute(Integer result) {
            refreshActivity();
        }
    }