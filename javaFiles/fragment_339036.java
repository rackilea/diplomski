public void fetchBackgroundImage(String url){
    ImageRequest imgRequest = new ImageRequest(url,
            new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap bitmap) {
                    Drawable banner = new BitmapDrawable(bitmap);
                    findViewById(R.id.headerImage).setBackgroundDrawable(banner);
                }
            },256,88,null,
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError ex) {
                     System.out.println(ex.getMessage().toString());
                }
            }
    );
    RequestQueue rq = Volley.newRequestQueue(this);
    rq.add(imgRequest);
}