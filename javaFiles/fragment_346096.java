@Override
            public boolean  shouldOverrideUrlLoading(WebView view, String url) {
                if(url != null && url.startsWith("whatsapp://"))
                {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Moon TV");
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);return true;

            }else
            {
                return false;
            }