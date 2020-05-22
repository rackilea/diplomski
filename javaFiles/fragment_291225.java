private String fetchErrorMessage(Throwable throwable) {

    String errorMsg = getResources().getString(R.string.error_msg_unknown);

    if (!isNetworkConnected()) {
        if (getActivity() != null){
        errorMsg = getActivity().getResources().getString(R.string.error_msg_no_internet);
        }
    } else if (throwable instanceof TimeoutException) {
        if (getActivity() != null){
        errorMsg = getActivity().getResources().getString(R.string.error_msg_timeout);
       }
    }

    return errorMsg;
}