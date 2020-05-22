// ... called the endpoint that returns a NavItem list
public void onResponse(String response) {
    ApiResult rootResult = gson.fromJson(response.toString(), ApiResult.class);
    if (rootResult.status.equals(STATUS_OK)) {
        Log.d(LOG_TAG, response.toString());
        NavItem.List resData = gson.fromJson(rootResult.data, NavItem.List.class); // <-- !!!!!
        callback.onSuccess(resData);
    }
    else {
        Log.e(LOG_TAG, response.toString());
        callback.onError(-1, null);
    }
}