public Html.ImageGetter getImageHTML() {

    Html.ImageGetter imageGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            try {

                String[] str = source.split("base64");

                Base64InputStream is = new Base64InputStream(new ByteArrayInputStream(str[1].getBytes()), 0);

                Bitmap decodedByte = BitmapFactory.decodeStream(is);

                Drawable drawable = new BitmapDrawable(getResources(), decodedByte);

                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

                return drawable;
            }catch(Exception e){
                e.getMessage();
                return null;
            }
        }
    };

    return imageGetter;
}