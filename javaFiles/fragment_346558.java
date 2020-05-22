AsyncTask asyncTask=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
               DownloadPost();
            }
        };
        asyncTask.execute();