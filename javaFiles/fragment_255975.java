List<String> url = new ArrayList<String>();
public Bitmap[] thumbs = new Bitmap[url.size()];

for (int i = 0; i < (url.size()); i++) {
   /* I fetch image with param String URL and return as Bitmap */
   thumbs[i] = fetchImage(url.get(i));
}