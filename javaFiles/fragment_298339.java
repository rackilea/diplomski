public class KategoriAdapter extends BaseAdapter {

private Context mContext;
private final String[] categoryValues;
private final Bitmap[] pictures;

//indicate that positon in list are all use new template
private List<Integer> mNewTemplatePos;
public ImageView categoryPictures;

//indicate that this  is normal template view
private final String NORMAL_TEMPLATE = "NORMAL_TEMPLATE";

//indicate that this  is new template view
private final String NEW_TEMPLATE = "NEW_TEMPLATE";

public KategoriAdapter(Context context, String[] categoryValues, Bitmap[] pictures) {
    this.mContext = context;
    this.categoryValues = categoryValues;
    this.pictures = pictures;
    this.mNewTemplatePos = new ArrayList<>();
}

//apply new template to positon
public void useNewTemplate(int pos) {
    mNewTemplatePos.add(pos);
    //notiy list that data has changed and the list will refresh ui itself.
    notifyDataSetChanged();
}

@Override
public int getCount() {
    return categoryValues.length;
}


@Override
public Object getItem(int possition) {
    return null;
}

@Override
public long getItemId(int possition) {
    return 0;
}

@Override
public View getView(int possition, View convertView, ViewGroup parent) {
    final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null) {
        if (mNewTemplatePos.contains(possition)) {
            convertView = getNewTemplate(inflater, possition);
            //use tag to indicate the type of the template
            convertView.setTag(NEW_TEMPLATE);
        } else {
            convertView = getNormalTemplate(inflater, possition);
            convertView.setTag(NORMAL_TEMPLATE);
        }
    } else {
        switch ((String) convertView.getTag()) {
            case NORMAL_TEMPLATE:
                //convertView is the normal template view but you need a new template view in possition
                if (mNewTemplatePos.contains(possition))
                    convertView = getNewTemplate(inflater, possition);
                break;
            case NEW_TEMPLATE:
                //convertView is the new template view but you need a normal template view in possition
                if (!mNewTemplatePos.contains(possition))
                    convertView = getNormalTemplate(inflater, possition);
                break;
        }
    }

    return convertView;
}


private View getNormalTemplate(LayoutInflater inflater, int possition) {
    View grid = inflater.inflate(R.layout.kategoriler_list_item, null);
    TextView cName = (TextView) grid.findViewById(R.id.grid_item_ad);
    categoryPictures = (ImageView) grid.findViewById(R.id.grid_item_resim);
    cName.setText(categoryValues[possition]);
    categoryPictures.setImageBitmap(pictures[possition]);
    return grid;
}

private View getNewTemplate(LayoutInflater inflater, int possition) {
    // TODO: 31/08/16 inflate you new template view layout here 
    return youNewTemplateView;
}

}