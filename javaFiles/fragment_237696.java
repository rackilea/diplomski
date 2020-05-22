public class ImageAdapter extends BaseAdapter 
{
    private Context myContext;

    private String[] myRemoteImages = arl.toArray(new String[arl.size()]);

    public ImageAdapter(Context c)
    { 
        this.myContext = c; 
    }
}