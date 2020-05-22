private WebView mWebView;
private boolean mUserHasAllowedUrlLoading = false;
private String mUrl;
...

@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {       

    // Store the url
    mUrl = url;

    // Keep the WebView so we can access it again in the AlertDialog's anonymous inner classes
    mWebView = view;

    if (!mUserHasAllowedUrlLoading) {
        // This is the first time the url has attempted to load, so show the dialog.

        // Build and show AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to Finish Process?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                mUserHasAllowedUrlLoading = true;

                // Start loading the stored url again
                mWebView.loadUrl(mUrl);

                dialog.dismiss();
            }

        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

        // We return true here so the WebView does not load anything for the moment
        return true;

    } else {
        // We can only get here if the user has already seen the dialog and clicked the positive button.

        // Reset the boolean so it's ready for next time the use tries to navigate away from the current page.
        mUserHasAllowedUrlLoading = false;

        // We return false this time so that the WebView actually loads the supplied url.
        return false;
    }
}