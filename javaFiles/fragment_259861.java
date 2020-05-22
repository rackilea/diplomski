Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        try {

            jObject = getJson("http://www.tabcards.com/req/androidapi/L2o30H8JlFMtFYHW3KLxkts20ztc5Be6Z6m6v315/json/"
                        + value);
            createUI(jObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});
thread.start();