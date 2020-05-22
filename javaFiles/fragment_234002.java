public class PropertyListAdapter extends ArrayAdapter<PropertyInfo> {

    private Context _context;
    private int layoutId;
    private List<PropertyInfo> dataList;
    private ListItemBtnClickInterface _interface;

    public PropertyListAdapter(Context context, int resource,
            List<PropertyInfo> objects, ListItemBtnClickInterface _interface) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
        _context = context;
        layoutId = resource;
        dataList = objects;
        this._interface = _interface;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.propertyImgView = (ImageView) convertView.
                    findViewById(R.id.propertyImgView);
            viewHolder.editImgView = (ImageView) convertView.
                    findViewById(R.id.editImgView);
            viewHolder.deleteImgView = (ImageView) convertView.
                    findViewById(R.id.deleteImgView);
            viewHolder.propertyNameTxtView = (TextView) convertView.
                    findViewById(R.id.propertyNameTxtView);
            viewHolder.ownerTypeTxtView = (TextView) convertView.
                    findViewById(R.id.ownerTypeTxtView);
            viewHolder.checkBox1 = (CheckBox) convertView.
                    findViewById(R.id.checkBox1);
            viewHolder.propertyNameTxtView.setTypeface(Utils.getRegularTypeface(_context));
            viewHolder.ownerTypeTxtView.setTypeface(Utils.getRegularTypeface(_context));

            viewHolder.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                    PropertyInfo element = (PropertyInfo) viewHolder.checkBox1
                      .getTag();
                  element.setSelected(buttonView.isChecked());

                }
              });

            convertView.setTag(viewHolder);
            viewHolder.checkBox1.setTag(dataList.get(position));
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
            ((ViewHolder) convertView.getTag()).checkBox1.setTag(dataList.get(position));
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.checkBox1.setChecked(dataList.get(position).isSelected());

        int height = viewHolder.propertyImgView.getLayoutParams().height;
        int width = viewHolder.propertyImgView.getLayoutParams().width;

        viewHolder.deleteImgView.setTag(position);
        viewHolder.editImgView.setTag(position);

        viewHolder.deleteImgView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Object data = v.getTag();
                if(data != null) {
                    _interface.listItemBtnClickListener(data, v.getId());
                }
            }
        });

        viewHolder.editImgView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Object data = v.getTag();
                if(data != null) {
                    _interface.listItemBtnClickListener(data, v.getId());
                }
            }
        });

        PropertyInfo addPropertyInfo = dataList.get(position);
        String propertyName = "";
        String ownerType = "";
        String imgPath = "";
        propertyName = addPropertyInfo.getPropertyName();
        ownerType = addPropertyInfo.getOwnerTypeName();
        imgPath = addPropertyInfo.getImagePath();

        viewHolder.propertyNameTxtView.setText(propertyName);
        viewHolder.ownerTypeTxtView.setText(ownerType);
        if(imgPath != null && !imgPath.equalsIgnoreCase("")) {
            Uri uri = Uri.parse(imgPath);
            Picasso.with(_context).load(uri)
            .resize(width, height).centerCrop().into(viewHolder.propertyImgView);
        } else {
            viewHolder.propertyImgView.setImageResource(R.drawable.no_img);
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView propertyImgView;
        ImageView editImgView;
        ImageView deleteImgView;
        TextView propertyNameTxtView;
        TextView ownerTypeTxtView;
        CheckBox checkBox1;
    }
}