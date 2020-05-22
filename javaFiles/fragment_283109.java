Single<LoginBean> getLoginResponse(Map<String, String> queryMap) {
    restApi.getLoginResponse(queryMap)
        .map(loginBeanResponse -> { if(loginBeanResponse.isError()) {
            Single.error(new Throwable(loginBeanResponse.getError().getErrorMessage()))
        } else { 
            Single.just(loginBeanReponse.getLoginBean()) 
        }})
}