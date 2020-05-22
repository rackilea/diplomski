protected void onPostExecute(Object result) {

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //UI related code
                }
            });
        }