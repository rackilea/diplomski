public class BookModel implements get_info.xyz {

    private void update_method() {
        get_info task = new get_info(this);
        task.exicute(some args); 
    }

    public void finishedCallback(String result) {
    // do some stuff when finsiehd. 
    }

 }
//----------------------------------
class get_info extends AsyncTask<HashMap<String, String>, Void, dataType>
{


    private xyz bookModel; 
    public interface xyz
    {
       void finishedCallback(String str);
    }
    public get_info ( xyz reset) {
        bookModel = reset; 
    }

    @Override
    protected dataType doInBackground(arg...)
                    some procscessing. 
    }

    protected void onPostExecute(dataType result) {
        bookModel.finishedCallback(result);
    }
}