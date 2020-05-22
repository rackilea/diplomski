public CustomTabsURLSpan(Context context,  String url) {
        super(url);
        this.context = context;
        if (context instanceof OnSendUrl) {
                mListener = (OnSendUrl) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnSendUrl");
            }
    }