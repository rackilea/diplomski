public class ImageAdapter extends BaseAdapter
{
private Context context;
private ArrayList<Integer> imagesIds;

public ImageAdapter(Context _context, ArrayList<Integer> _imageIds)
{
    context = _context;
    imageIds = _imageIds;
}


@Override
public int getCount()
{
    return imgIds.size();
}

@Override
public Object getItem(int position)
{
    return null; 
}

@Override
public long getItemId(int position) {
    return 0;
}

@Override
public View getView(int position, View convertView, ViewGroup parent)
{
    ImageView view;

    if( convertView != null ) // recycle call
    {
        view = (ImageView) convertView;
    }
    else
    {
        view = new ImageView(context);
        image.setBackgroundResource(imageIds.get(position));
    }

    return view;
}
}