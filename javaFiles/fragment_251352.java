public class DownloadImageTaskDAO extends AsyncTask<ImageView, Void, ArrayList<DownloadImageTaskDAO.Container>> {

    @Override
    protected ArrayList<Container> doInBackground(ImageView... imageViews) {
         ArrayList<Container> results = new ArrayList<Container>(imageViews.length);

         for (ImageView imageView : imageViews) {
             Container tmp = new Container();
             tmp.holder = imageView;
             tmp.image = download_Image(imageView.getTag().toString());
             results.add(tmp);
         }

         return results;
    }

    @Override
    protected void onPostExecute(ArrayList<Container> result) {
        for (Container container : result) {
            container.holder.setImageBitmap(container.image);
        }
    }

    private Bitmap download_Image(String url) {
        ....
    }

    class Container {
        ImageView holder;
        Bitmap image;
    }
}