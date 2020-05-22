public void LoadThisUrl(View view) {
        if(view==findViewById(R.id.Google)){
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra("Url", "http://google.com");
            startActivity(i);
        }
        if(view==findViewById(R.id.Facebook)){
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra("Url", "http://facebook.com");
            startActivity(i);
        }
        if(view==findViewById(R.id.Twitter)){
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra("Url", "http://twitter.com");
            startActivity(i);
        }
    }