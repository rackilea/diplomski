public void onClick(View view) {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setQuote("This may be used to replace setTitle and setDescription.")
                    .setContentUrl(Uri.parse("www.website.com"))
                    .build();
            shareDialog.show(linkContent);
        }
    }