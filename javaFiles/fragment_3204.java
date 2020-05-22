public class LoadPictureAsyncTask extends AsyncTask<Void, Void, Bitmap> {       
    private Context context;        
    private ImageView myProfPic;        

    public LoadPictureAsyncTask(Context mycontext,ImageView ProfPic){
        this.context = mycontext;           
        this.myProfPic = ProfPic;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPreExecute()
    {       }

    @Override
    protected Bitmap doInBackground(Void... params) {
        Bitmap bitmap;
        try
        {

        URL imageURL = new URL("http://upload.wikimedia.org/wikipedia/commons/5/57/PT05_ubt.jpeg");
            bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
        }catch(Exception ex)
        {
             bitmap = null;
        }                               

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result)
    {                   
        if(result!=null)
            {                               
                myProfPic.setImageBitmap(result);               
            }           
    }