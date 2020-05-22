NetworkImageView hsvimage1 = (NetworkImageView) findViewById(R.id.hsvimage1);
NetworkImageView hsvimage2 = (NetworkImageView) findViewById(R.id.hsvimage2);
NetworkImageView hsvimage3 = (NetworkImageView) findViewById(R.id.hsvimage3);

// Get image URLs from your previous network request...
// I could not determine where this is stored from code in your question.
String url1 = ...;   // e.g. http://example.com/images/image1.png
String url2 = ...;
String url3 = ...;

// Set the URL of the image that should be loaded into this view, and
// specify the ImageLoader that will be used to make the request.
hsvimage1.setImageUrl(url1, mImageLoader);
hsvimage2.setImageUrl(url2, mImageLoader);
hsvimage3.setImageUrl(url3, mImageLoader);