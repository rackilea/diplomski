private class UrlLookup extends AsyncTask<Object, Integer, String>{
    Bitmap bmp;
    ImageView view;

    @Override
    protected String doInBackground(Object... params){ 
        view = (ImageView) params[1]; 
        try {
            URL u = new URL((String)params[0]);
            bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());
        } catch (Exception e) { e.printStackTrace(); }

        return "Done!";
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);    
        view.setImageBitmap(bmp);
    }
}