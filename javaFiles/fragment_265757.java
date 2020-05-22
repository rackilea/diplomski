class ImageScrapAsyncTask extends AsyncTask<String, Void, Document> {

    @Override
    protected Document doInBackground(String... urls) {
        try {
            return Jsoup.connect(urls[0]).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Document document) {
        if (document != null) {
            Elements imgElements = document.select("img");
            List<String> images = new ArrayList<>();
            for (Element element : imgElements) {
                String image = element.attr("data-src");
                /*Note data-src is used instead of src, as example 
                you provided uses lazy loading and has image file 
                url inside data-src attribute. You may need to use 
                src for other pages. */
                Log.d("IMAGE_URL", image);
                images.add(image);
            }
        }
    }
}