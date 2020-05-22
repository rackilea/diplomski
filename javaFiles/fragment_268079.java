WebService webService=new WebService(context,"url",jsonObject);
    webService.start(new WebService.OnWebCompleteListener() {
    @Override
    public void onComplete(JSONObject result, int dataSource) {

    }

    @Override
    public void onError(String error) {

    }
    });