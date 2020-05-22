@Override
    public void run() {

        try {

            BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(is);
            ...
        finally {
            try {
                connection.close();