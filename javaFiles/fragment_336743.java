Toast mToast; 

private void showUserStatus(final String msg, final int length) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(getActivity(), msg, length);
                mToast.show();
            }
        });
    }