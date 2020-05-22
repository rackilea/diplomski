public class ImageAdapter extends BaseAdapter {



private Context mContext;
public static String[] mThumbIds;
int imageTotal;




 public ImageAdapter(Context c,String[] mThumbIds) {
        mContext = c;
this.mThumbIds= mThumbIds
    }