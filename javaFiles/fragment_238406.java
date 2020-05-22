boolean flag;
    @Override
    protected String doInBackground (String... params) {
        flag= params[0].endsWith("/repos");
        //other statements
    }