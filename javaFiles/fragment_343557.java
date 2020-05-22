public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        view.loadUrl("javascript: {" +
        "$('input#username').val('" + user + "');\n" +
        "$('input#username').val(\"password\");\n" +
        "document.querySelectorAll(\"button[type='submit']\")[0].click();}");

    }